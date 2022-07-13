n,k = map(int,input().split())

count = 0               ## 연산 횟수 

while(n>1):

    if n % k != 0:
        n -= 1
        count += 1

    elif n % k == 0:
        n = n / k
        count += 1

    elif n != 1:
        continue
    else:
        break



print(count)
