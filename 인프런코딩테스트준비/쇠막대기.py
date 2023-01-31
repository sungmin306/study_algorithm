# 구현을 못해서 알고리즘 풀이만 보고 코딩해봄

# s = input()
# L = list(map(str, s)) # 입력한 값 리스트로 변환

# Stack = [] # 스택
# M = [] # 막대
# R = [] # 레이저 저장 리스트

# for i in range(len(L)):
#     a = L[i]
#     if a == "(":
#         Stack.append(a)

# 구현을 못해서 알고리즘 풀이만 보고 코딩해봄 -> 내 방식과 달랐다 구현 완료

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
"""
선생님 코드
s=input()
stack=[]
cnt=0
for i in range(len(s)):
    if s[i]=='(':
        stack.append(s[i]) 
    else:
        stack.pop() # 원래 if 안 else 안에 있어야하는데 코드가 중복되므로 앞으로 뺌
        if s[i-1]=='(':
            cnt+=len(stack)
        else:
            cnt+=1
print(cnt)
"""
