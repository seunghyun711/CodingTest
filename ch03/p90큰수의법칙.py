n,m,k = map(int,input().split())
arr = list(map(int,input().split()))

result = 0

arr.sort()
maxNum1 = arr[n-1]
maxNum2 = arr[n-2]

while(True):
    for i in range(k):
        if m == 0:
            break
        result += maxNum1
        m -= 1

    if m == 0:
        break

    result += maxNum2
    m -= 1

print(result)
        
