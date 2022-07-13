n,m = map(int,input().split())
a,b,direction = map(int,input().split())
road =[]        # 전체 맵의 좌표를 저장한 리스트
tmp = [[0] * m for k in range(n)] # 방문 여부를 파악하는 리스트
visited = 0     # 방문기록

# 동 서 남 북 좌표
west = [0,-1]
east = [0, 1]
north = [-1,0]
south = [1, 0]

count = 1   # 방문한 칸의 수
tmp[a][b] = 1

for i in range(n):
    road.append(list(map(int,input().split())))

## 왼쪽으로 회전하는 함수
def left(direction):
    if direction == 0:
        direction = 3
    else:
        direction -= 1

def noWayNorth():
    global a,b,tmpA,tmpB

    tmpA = a - north[0]
    tmpB = b - north[1]
    if road[tmpA][tmpB] == 0:
        a = tmpA
        b = tmpB

def noWayEast():
    global a,b,tmpA,tmpB
    tmpA = a - east[0]
    tmpB = b - east[1]
    if road[tmpA][tmpB] == 0:
        a = tmpA
        b = tmpB

def noWaySouth():
    global a, b, tmpA, tmpB
    tmpA = a - south[0]
    tmpB = b - south[1]
    if road[tmpA][tmpB] == 0:
        a = tmpA
        b = tmpB

def noWayWest():
    global a, b, tmpA, tmpB
    tmpA = a - west[0]
    tmpB = b - west[1]
    if road[tmpA][tmpB] == 0:
        a = tmpA
        b = tmpB

## 길찾기 노가다
while(True):
    left(direction)
    if direction == 0: ## 북쪽
        tmpA = a + north[0]
        tmpB = b + north[1]
        if tmp[a][b] == 0 and road[a][b] == 0:
            tmp[a][b] = 1
            a = tmpA
            b = tmpB
            count += 1
            continue
        else:
            visited += 1

    elif direction == 1:  # 동쪽
        tmpA = a + east[0]
        tmpB = a + east[1]
        if tmp[a][b] == 0 and road[a][b] == 0:
            tmp[a][b] = 1
            a = tmpA
            b = tmpB
            count += 1
            continue
        else:
            visited += 1

    elif direction == 2:   # 남쪽
        tmpA = a + south[0]
        tmpB = b + south[1]
        if tmp[a][b] == 0 and road[a][b] == 0:
            tmp[a][b] = 1
            a = tmpA
            b = tmpB
            count += 1
            continue
        else:
            visited += 1

    elif direction == 3:   # 서쪽
        tmpA = a + west[0]
        tmpB = b + west[1]
        if tmp[a][b] == 0 and road[a][b] == 0:
            tmp[a][b] = 1
            a = tmpA
            b = tmpB
            count += 1
            continue
        else:
            visited += 1

    if visited == 4:
        if direction == 0:
            noWayNorth()

        elif direction == 1:
            noWayEast()

        elif direction == 2:
            noWaySouth()

        elif direction == 3:
            noWayWest()

        else:
            break
        visited = 0

print(count)