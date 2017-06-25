import sys
n = int(input())
stack = []
maxElement = -sys.maxsize
for i in range(0,n):
    op = list(map(int,input().strip().split(' ')))
    if op[0] == 1:
        stack.append(op[1])
        if op[1] > maxElement: 
            maxElement = op[1]
    if op[0] == 2:
        if stack.pop() == maxElement:
            maxElement = max(stack) if len(stack) > 0 else -sys.maxsize
    if op[0] == 3:
        print(maxElement)

