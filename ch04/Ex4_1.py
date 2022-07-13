n = int(input())
x,y = 1,1
directions = input().split()

dx = [0, 0, -1,1]
dy = [-1, 1, 0, 0]
move = ['L','R','U','D']

for plan in directions:
    for i in range(len(move)):
        if plan == move[i]:
            print(plan)
            nx = x + dx[i]
            ny = y + dy[i]
            print(nx,ny)

    if nx<1 or ny<1 or nx>n or ny>n:
        continue
    x,y = nx,ny

print(x,y)
