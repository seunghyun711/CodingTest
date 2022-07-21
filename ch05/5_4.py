from collections import deque

n, m = map(int, input().split())
graph = []

for i in range(n):
    graph.append(list(map(int, input())))

## 위 아래 왼 오
directionX = [-1, 1, 0, 0]
directionY = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):

            nx = x + directionX[i]
            ny = y + directionY[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            elif graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

            elif graph[nx][ny] == 0:
                continue

            elif nx == n - 1 and ny == m - 1:
                break

    return graph[n - 1][m - 1]


print(bfs(0, 0))


