s = input()
L = list(map(str, s))

Stack = [] # 스택
M = [] # 막대
R = [] # 레이저 저장 리스트

for i in range(len(L)):
    a = L[i]
    while Stack and a == ")":
        Stack.pop()
        
    else: 
        Stack.append(a)
