#!/bin/python3

import sys

def encrypt(key,plain):
    enrypted = list(plain)
    for i,c in enumerate(enrypted):
        x = ord(c)
        if (x > 64 and x < 91):
            x -= 65
            x += key
            x %= 26
            x += 65
            enrypted[i] = chr(x)
        else:
            if (x > 96 and x < 123):
                x -= 97
                x += key
                x %= 26
                x += 97
                enrypted[i] = chr(x)
    return "".join(enrypted)
n = int(input().strip())
s = input().strip()
k = int(input().strip())
print(encrypt(k,s))