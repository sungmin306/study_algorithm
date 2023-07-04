# 내 코드 (틀림)
"""
def DFS(v,sum,t):
    global res
    if t > n:
        return
    if n == v:
        if res < sum:
            res = sum
            print("res 값은?",res)
    else:
        print("sum 값은", sum)
        print("t 값은", t)
        print("sum + P[t] 값은", sum + P[t])
        print("t+T[t]", t+T[t])
        if v < t+T[t]:
            DFS(v+1, sum + P[t], t+T[t] ) #포함한다
        DFS(v+1,sum,t) #포함 안한다

#### main
n = int(input())
#L=[[0]*(2) for _ in range(n)]
# print(L)
T=list()
P=list()
for i in range(n):
    a, b =map(int,input().split())
    T.append(a)
    P.append(b)
#print(L)
res=-999999999
DFS(0,0,0)
print(res)
"""


# 선생님 코드
def DFS(L,sum):
    global res
    if L == n + 1:
        if sum > res:
            res = sum
    else:
        if L + T[L] <= n + 1:
            DFS(L+T[L], sum + P[L]) # 해당하는 상담 선택했을 때 -> 걸리는 날짜시간으로 감
        DFS(L+1, sum) # 해당하는 상담을 선택 안했을 때 -> 다음 상담을 받을지 안받을지 결정

n = int(input())
T=list()
P=list()
for i in range(n):
    a, b =map(int,input().split())
    T.append(a)
    P.append(b)
res= - 2147000000
T.insert(0,0) # list 앞에 0 넣는행위 원래 있던 값들을 오른쪽으로 한칸씩 미는 효과 발생
P.insert(0,0)
DFS(1,0)
print(res)

