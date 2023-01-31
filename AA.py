s = input()
L = list(map(str, s))
S=[] # Stack
sum = 0

for i in range(len(L)):
    a = L[i]
    if a == "(":
        S.append(a)
    elif a == ")":
        if L[i-1] == "(":
            S.pop()
            sum+=len(S)
        elif L[i-1] == ")":
            S.pop()
            sum+=1
    # print(sum)

print(sum)