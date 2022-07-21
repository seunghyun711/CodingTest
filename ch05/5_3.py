n,m = map(int,input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input())))

visited = [[False] * m] * n

## 위 아래 왼 오
directionX = [-1, 1, 0, 0]
directionY = [0, 0, -1, 1]

def dfs(x,y):
    if x<0 or y<0 or x>=n or y>=m:
        return False

    elif graph[x][y] == 0:
        graph[x][y] = 1
        i = 0
        for i in range(4):
            nx = x + directionX[i]
            ny = y + directionY[i]
            dfs(nx,ny)

        return True
    return False

count = 0
for k in range(n):
    for j in range(m):
        if dfs(k,j) == True:
            count += 1
print(count)










