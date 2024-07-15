# 1. 공격 시간(마지막 공격이 이루어지는 시간) 동안 회복, 공격 동작 수행
# 2. 마지막 공격을 받은 시점에 남은 체력 리턴 
def solution(bandage, health, attacks):
    recoveryTime = bandage[0] # 회복 시전 시간
    recoveryPerSec = bandage[1] # 초당 회복량
    addtionalRecovery = bandage[2] # 추가 회복량
    continualRecovery = 0 # 연속 회복에 성공한 시간
    
    i = 0
    
    attackTime = attacks[-1][0] # 공격 시간(마지막 공격이 이루어지는 시간)
    damage = 0 # 피해량 
    remainHp = health # 남은 체력
    
    # 1. 공격 시간(마지막 공격이 이루어지는 시간) 동안 회복, 공격 동작 수행
    for time in range(attackTime+1):    
        # 공격 시간이 된 경우 해당 시간의 데미지만큼 남은 체력에서 차감
        if(time == attacks[i][0]):
            remainHp -= attacks[i][1]
            continualRecovery = 0 # 공격 성공시 연속 회복 성공 초기화
            i += 1
        # 체력회복
        else:
            # remainHp >= health인 경우 남은 체력을 health로 하도록 min함수를 통해 health와 계산된 남은 체력 중 작은 값을 remainHp로 설정
            remainHp = min(health, remainHp + recoveryPerSec)
            continualRecovery += 1 # 연속 회복 시간 증가
            
            # 연속 회복 시간이 회복 시전 시간과 같아지면 추가 회복량을 남은 체력에 더하고, 연속 성공 시간은 초기화    
            if (continualRecovery == recoveryTime):
                remainHp = min(health, remainHp + addtionalRecovery)
                continualRecovery = 0
        # 남은 체력이 0 이하인 경우 체력을 -1로 설정하여 반복문 종료
        if(remainHp <= 0):
            return -1
            
    # 2. 마지막 공격을 받은 시점에 남은 체력 리턴
    return remainHp
