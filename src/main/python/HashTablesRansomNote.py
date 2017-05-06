def ransom_note(magazine, ransom):
    dict = {}
    for m in magazine:
        dict[m] = dict.get(m , 0) + 1
    for r in ransom:
        dict[r] = dict.get(r , 0) - 1
    for key,value in dict.items():
        if value < 0:
            return False
    return True

m, n = map(int, input().strip().split(' '))
magazine = input().strip().split(' ')
ransom = input().strip().split(' ')
answer = ransom_note(magazine, ransom)
if(answer):
    print("Yes")
else:
    print("No")

