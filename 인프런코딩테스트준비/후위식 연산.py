a=input() # 후위식 연산입력
S=[] # Stack
for x in a:
    #print(S)
    if x.isdecimal():
        S.append(x)
    else:
        f = int(S.pop())
        e = int(S.pop())
        if x =='+':
            S.append(f+e)
        elif x =='-':
            S.append(e-f)
        elif x == '*':
            S.append(f*e)
        elif x ==  '/':
            S.append(f/e)
print(S[0])