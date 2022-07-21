def fact_i(n):
    result = 1

    for i in range(1,n+1):
        result *= i
    return result

def fact_recursive(n):
    if n<=1:
        return 1
    return n * fact_recursive(n-1)

print("반복 구현 : " ,fact_i(5))
print("재귀 구현 : ",fact_recursive(5))
