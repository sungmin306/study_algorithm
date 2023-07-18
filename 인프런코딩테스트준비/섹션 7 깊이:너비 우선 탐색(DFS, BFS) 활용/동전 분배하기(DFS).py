# 내코드 틀림 (가지치기에서 문제가 있는 거 같다)
"""
def DFS(v):
    global res
    if L[0] != 0 and L[1] != 0 and L[2] != 0:
        if L[0] == L[1] == L[2]:
            return
    if v == n:
        com_val = max(ch) - max(ch)
        if res > com_val:
            res = com_val
    else:
        for i in range(3):
            ch[i] += L[v] # 값을  추가
            DFS(v+1)
            ch[i] -= L[v] # 백트레킹 할때 값 빼기

n = int(input())
L=list()
res = 9999999
ch=[0,0,0]
for i in range(n):
    a = int(input())
    L.append(a)
DFS(0)
print(res)
"""

#### 선생님 코드

def DFS(L):
    global res
    if L==n:
        cha=max(money)-min(money)
        if cha<res:
            # 서로 다른지를 확인하기 위새 set을 이용한다는 생각을 내가 못했다.
            tmp=set() # set을 활용해서 3개의 값이 다른지 확인
            for x in money:
                tmp.add(x)
            if len(tmp)==3: # 같으면 set의 길이가 3이 될 수 없음
                res=cha
    else:
        for i in range(3):
            money[i]+=coin[L]
            DFS(L+1)
            money[i]-=coin[L]

    n=int(input())
    coin=[]
    tmp=[]
    money=[0]*3
    res=2147000000
    for _ in range(n):
        coin.append(int(input()))
    DFS(0)
    print(res)