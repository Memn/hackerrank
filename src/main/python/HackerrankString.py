#!/bin/python3

import sys

def hackerrank(s):
    hackerrank = "hackerrank"
    i = 0
    for c in s:
        if c == hackerrank[i]:
            i += 1
            if i == len(hackerrank):
                return True
    return False


q = int(input().strip())
for a0 in range(q):
    s = input().strip()
    if(hackerrank(s)):
        print("YES")
    else:
        print("NO")
