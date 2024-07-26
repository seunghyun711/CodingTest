# 특정 원소가 속한 집합 찾기
def find_parent(parent, x):
    # 루트 노드가 아니면 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

# 노드의 개수와 간선의 개수 입력
n,m = map(int,input().split())
parent = [0] * (n+1) # 부모 테이블 초기화

# 모든 간선을 담을 리스트와 최종 비용을 담을 변수
edges = []
result = 0

# 부모 테이블상에서 부모를 자기 자신으로 초기화
for i in range(1,n+1):
    parent[i] = i

# 모든 간선에 대한 정보 입력받기
for _ in range(m):
    a,b,c = map(int,input().split())
    # 비용 순으로 정렬하기 위해 튜플의 첫 번째 원소를 비용으로 설정
    edges.append((c,a,b))

# 간선을 비용순으로 정렬
edges.sort()
link = 0 # 두 마을을 연결하는 비용을 저장하는 변수

# 간선을 하나씩 확인
for edge in edges:
    c,a,b = edge
    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if find_parent(parent,a) != find_parent(parent, b):
        union_parent(parent,a,b)
        result += c
        link = c

result -= link
print(result)