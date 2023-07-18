# 내 코드(틀림)
"""
def DFS(t,s,h):
    if t <= m:
            if ch[i] == 0:
                ch[i] = 1
                L.append(s+g[i][0])
                print(t)
                DFS(t+g[i][1],s+g[i][0],h+1)
                ch[i] = 0
    

n , m = map(int,input().split())
L=[]
ch=[0] * (n + 1)
g=[[0] * 2 for _ in range(n+1)]
print(g)
for i in range(1,n+1):
    a, b = map(int,input().split())
    g[i][0] = a
    g[i][1] = b
print(g)
DFS(0,0,0) # 시간, 합, 레벨
print(max(L))
print(L)
"""
# 선생님코드

def DFS(L, sum, time):
    global res
    if time>m:
        return
    if L==n:
        if sum>res:
            res=sum
    else:
        DFS(L+1, sum+pv[L], time+pt[L])
        DFS(L+1, sum, time)



n, m=map(int, input().split())
pv=list()
pt=list()
for i in range(n):
    a, b=map(int, input().split())
    pv.append(a)
    pt.append(b)
res=-2147000000
DFS(0, 0, 0)
print(res)