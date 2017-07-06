#!/bin/python3

import sys
def weightStr(str, x):
    uniformWieghts = []
    subTotal = 0
    lastChar = None
    for c in str:
        if c == lastChar:
            subTotal += (ord(c)-96)
            uniformWieghts.append(subTotal)
        else:
            uniformWieghts.append(ord(c)-96)
            subTotal = 0
            lastChar = c
    return x in uniformWieghts

s = input().strip()
n = int(input().strip())
for a0 in range(n):
    x = int(input().strip())
    if(weightStr(s,x)):
        print("YES")
    else:
        print("NO")
