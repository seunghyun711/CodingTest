n,k = map(int,input().split())
count = 0

while(True):
    t = (n//k)*k
    count += (n-t)
    n = t
    print("n = :",n)
    print(count)

    if n < k:
        break

   
    n//=k
    count += 1
    print(count)

count += (n-1)
print(count)
