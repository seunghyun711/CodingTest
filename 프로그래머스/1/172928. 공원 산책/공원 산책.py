# 1. 시작점 설정
# 2. 규칙과 routes에 따라 좌표 이동
def solution(park, routes):
    # 1. 시작점 설정
    x, y = 0, 0 # 시작점
    w, h = len(park[0]), len(park) # 가로, 세로 길이
    nx, ny = 0,0
    
    # N, S, W, E에 따른 이동 방향
    moveTypes = {"N" : [-1,0], "S" : [1,0], "W" : [0,-1], "E" : [0,1]}
    
    for i in range(h):
        for j in range(w):
            # 현재 탐색 좌표가 시작점인 경우 startX, startY에 해당 좌표값 대입
            if(park[i][j] == 'S'): 
                x, y = i, j
                break
    
    # 3. 규칙과 routes에 따라 좌표 이동
    for i in routes:
        direction, movement = i.split(" ") # diretion : 방향, movement : 이동할 칸의 수
        currentX, currentY = x, y # 현재 위치
        
        for j in range(int(movement)):
            nx = x + moveTypes[direction][0]
            ny = y + moveTypes[direction][1]
            
            if(0 <= nx <= h-1 and 0 <= ny <= w-1) and(park[nx][ny] != 'X'):
                x, y = nx, ny

            # 이동한 위치가 유효하지 않은 위치면 해당 위치에서의 탐색은 중단하고 다음 routes 탐색
            else:
                x, y = currentX, currentY
                break
            
    return(x,y)        