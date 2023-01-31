# 스택 활용해서 풀어보기
n, m = map(int,input().split())
n=str(n)
S = [] # Stack
for i in range(len(n)):
    a = int(n[i])
    #print(S)
    if len(S) == 0:
        S.append(a)
        #continue # 아래 코드 실행 x 바로 다음 i 값으로 넘어 갈 수 있음
    else:
        while True:
            if len(S) == 0:
                S.append(a)
                break
            else:
                if m > 0 and S[-1] < a:
                    S.pop()
                    m = m - 1
                else:
                    S.append(a)
                    break

if m > 0:
    S= S[:-m]
for i in S:
    print(i,end="")
print()
# 너무 비효율적으로 짠거같다 코드가 쓸대없이 길다
"""
선생님 코드
num=list(map(int, str(num)))
stack=[]
for x in num:
    while stack and m>0 and stack[-1]<x:
        stack.pop()
        m-=1
    stack.append(x)
if m!=0:
    stack=stack[:-m]
res=''.join(map(str, stack))
print(res)

"""
        

    