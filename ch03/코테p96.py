
n,m = map(int,input().split())

result = 0
tmp = []
i = 0


for k in range(n):
    if i > n:
        break
    arr = list(map(int,input().split()))
    minValue = min(arr)
    tmp.append(minValue)
    i += 1

result = max(tmp)     
print(result)

    











