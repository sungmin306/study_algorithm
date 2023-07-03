# 내코드 (정답)
"""
def DFS(v):
    global cnt 
    if v == n :
        cnt = cnt + 1
    else:
        for i in range(1,n+1):
            if ch[v] == 0 and g[v][i] == 1:
                #print("조건문 들어옴")
                ch[v] = 1
                DFS(i)
                ch[v] = 0
            
#### main
n , m = map(int,input().split())
cnt = 0
ch = [0] * (n + 1) # 지나갔는지 안 지나갔는지 확인
ch[1] == 1
g = [[0 for j in range(n + 1)] for i in range(n + 1)]

for i in range(1,m+1): 
        a ,b = map(int,input().split())
        g[a][b] = 1

DFS(1)
print(cnt)
"""
# 선생님 코드
def DFS(v):
    global cnt
    if v == n:
        cnt += 1
        for x in path:
            print(x, end = ' ')
        print()
    else:
        for i in range(1,n+1):
            if g[v][i] ==1 and ch[i] == 0:
                path.append(i)
                ch[i] = 1 
                DFS(i)
                path.pop()
                ch[i] = 0



# 선생님 코드
n, m = map(int,input().split())
g= [[0]*(n+1) for _ in range(n+1)]
ch=[0] * (n+1)
path=[]
path.append(1)
for i in range(m):
    a, b = map(int,input().split())
    g[a][b] = 1
cnt = 0
ch[1] = 1
DFS(1)