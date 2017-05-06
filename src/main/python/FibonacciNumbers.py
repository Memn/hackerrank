def fibonacci(n):
    fib = [0,1]
    if n>1:
        for i in range(2,n+1):
            fib[i] = fib[i-1] + fib[i-2]
    return fib[n]
    # Write your code here.
n = int(input())
print(fibonacci(n))
