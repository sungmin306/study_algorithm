# 괄호 문제를 해결하지 못했다.
# n = input()

# L = [] #후위표기식
# S = [] # Stack

# for i in n:
#     if i.isdigit():
#         L.append(i)
#     else:
#         if i == "("
#         for j in range(len(S)):

a = input()
res=''
S=[] # Stack

for x in a:
    if x.isdecimal():
        res+=x
    else:
        if x == '(':
            S.append(x)
        elif x == '*' or x =='/':
            while S and (S[-1] =='*' or S[-1]=='/'):
                res+=S.pop()
            S.append(x)
        elif x =='+' or x =='-':
            while S and (S[-1]!='('):
                res+=S.pop()
            S.append(x)
        elif x == ')':
            while S and S[-1]!='(':
                res+=S.pop()
            S.pop()
while S:
    res+=S.pop()
print(res)










            
"""
선생님 코드
a=input()
stack=[]
res=''
for x in a:
    if x.isdecimal(): #10진수인지 확인
        res+=x
    else:
        if x=='(':
            stack.append(x)
        elif x=='*' or x=='/':
            while stack and (stack[-1]=='*' or stack[-1]=='/'):
                res+=stack.pop()
            stack.append(x)
        elif x=='+' or x=='-':
            while stack and stack[-1]!='(':
                res+=stack.pop()
            stack.append(x)
        elif x==')':
            while stack and stack[-1]!='(':
                res+=stack.pop()
            stack.pop()
while stack:
    res+=stack.pop()
print(res)
"""
            
