# 1. 선물 지수를 계산하는 메서드 구현
    # 1-1. 선물을 주고 받은 개수와 선물 지수를 저장할 2차원 배열 선언
    # 1-2. gifts 배열을 통해 주고 받은 선물의 수를 계산하여 1-1에 선언한 배열에 저장
    # 1-3. 1-2의 결과를 바탕으로 선물 지수 계산하여 결과 리턴
    
# 2. 1번에서 구한 지수를 이용해 다음 달에 선물을 가장 많이 받는 사람의 선물의 개수 계산
    # 2-1. 두 사람 사이에 선물을 주고받은 경우 두 사람 간 더 많은 선물을 준 사람에게 선물 1개 추가
    # 2-2. 두 사람이 선물을 주고받지 않은 경우 지수를 비교해 지수가 더 큰 사람에게 선물 1개 추가
    # 2-3. 지수가 모두 같은 경우 
# 1. 선물 지수를 계산하는 메서드 구현
def calcGiftExponent(friends, gifts):
    numFriends = len(friends) # 친구의 수
    # 1-1. 선물을 주고 받은 개수와 선물 지수를 저장할 2차원 배열 선언(모든 인덱스 0으로 초기화)
    # 여기서 numFirends+1개의 행과 numFriends개의 열로 선언하는 이유는 행의 마지막 인덱스에는 지수를 계산하여 넣을 것이기 때문.
    giftArr = [[0 for i in range(numFriends+1)] for _ in range(numFriends)]
    
    giftExponent = [0 for i in range(numFriends)] # 개인별 선물 지수를 담을 배열
    
    # 1-2. gifts 배열을 통해 주고 받은 선물의 수를 계산하여 1-1에 선언한 배열에 저장
    for name in gifts:
        provider, receiver = name.split(); # gifts 배열에 split을 이용해 provider에는 선물을 준 사람의 이름을, receiver에는 선물을 받은 사람의 이름이 들어간다.
        giftArr[friends.index(provider)][friends.index(receiver)] += 1

    # 1-3. 1-2의 결과를 바탕으로 선물 지수 계산하여 결과 리턴
    totalProvidedGifts = [0 for i in range(numFriends)] # 개인별 준 선물의 총개수를 담은 배열
    totalReceivedGifts = [0 for i in range(numFriends)] # 개인별 받은 선물의 총개수를 담은 배열
    
    # 개인별 준 선물의 총개수 계산
    for i in range(numFriends):
        for j in range(numFriends):
            totalProvidedGifts[i] += giftArr[i][j]
        
    # 개인별 받은 선물의 총개수 계산
    for i in range(numFriends):
        for j in range(numFriends):
            totalReceivedGifts[i] += giftArr[j][i]
    
    # totalProvidedGift - totalReceivedGifts로 선물 지수 계산
    for i in range(numFriends):
        giftExponent[i] = totalProvidedGifts[i] - totalReceivedGifts[i]
        
    # giftArr[i][numFriends]에 계산한 선물 지수를 삽입
    for i in range(numFriends):
        giftArr[i][numFriends] = giftExponent[i]
        
    return giftArr

# 2. 1번에서 구한 지수를 이용해 다음 달에 선물을 가장 많이 받는 사람의 선물의 개수 계산
def solution(friends, gifts):
    numFriends = len(friends) # 친구의 수
    giftArr = calcGiftExponent(friends, gifts)
    giftsList = [0 for _ in range(numFriends)] # 개인별 다음달에 받을 수 있는 선물의 개수
    answer = 0
    
    for i in range(numFriends):
        for j in range(i + 1, numFriends):
            # 2-1. 두 사람 사이에 선물을 주고받은 경우 두 사람 간 더 많은 선물을 준 사람에게 선물 1개 추가
            if(giftArr[i][j] != 0 or giftArr[j][i] != 0) and (giftArr[i][j] != giftArr[j][i]):
                if(giftArr[i][j] > giftArr[j][i]):
                    giftsList[i] += 1;
                else:
                    giftsList[j] += 1;
            # 2-2. 두 사람이 선물을 주고받지 않은 경우 지수를 비교해 지수가 더 큰 사람에게 선물 1개 추가
            else:
                if(giftArr[i][numFriends] > giftArr[j][numFriends]):
                    giftsList[i] += 1
                elif(giftArr[i][numFriends] < giftArr[j][numFriends]):
                    giftsList[j] += 1
    return max(giftsList)

