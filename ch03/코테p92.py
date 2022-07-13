n,m,k = map(int,input().split())
arr = list(map(int,input().split()))

arr.sort()
result = 0
i = 0

maxNum1 = arr[n-1]
maxNum2 = arr[n-2]


print(arr)

while(True):
    for i in range(k):
        if m == 0:
            break
        result += maxNum1
        print(result)
        m -= 1

    
    if m == 0:
        break
    
    else:
        result += maxNum2
        print(result)
        m -= 1
        continue

    
    
    
    
print(result)
