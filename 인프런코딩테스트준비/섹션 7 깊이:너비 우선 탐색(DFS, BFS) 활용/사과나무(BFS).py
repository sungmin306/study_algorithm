# 내 코드 정답 (x)
"""
from collections import deque
n = int(input())
L=[]
for i in range(n):
    a = list(map(int,input().split()))
    L.append(a)
print(L)
ch = [[0 for j in range(n)] for i in range(n)]
dq = deque()
dq.append((n//2,n//2))
s = 0
cnt = 0
ch[n//2][n//2] = 1
# print(now)
# print(now[0])
while dq:

    print(dq)
    now = dq.popleft()
    print("now 값",now)
    print("더해지는 값",L[now[0]][now[1]])
    s += L[now[0]][now[1]]
    print("총합계",s)
    if now[0] > 0 and now[1] > 0: # 이부분을 아직도 잘 모르겠다..
        for next in ( (now[0]-1,now[1]), (now[0]+1,now[1]), (now[0], now[1]-1), (now[0],now[1]+1)):
            if ch[next[0]][next[1]] == 0:
                dq.append(next)
                ch[next[0]][next[1]] = 1
        cnt+=1
print(s)
"""

#### 선생님 코드
from collections import deque
dx = [-1,0,1,0]
dy = [0,1,0,-1]
n= int(input())
a = [list(map(int,input().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]
sum = 0
Q=deque()
ch[n//2][n//2] = 1
sum+=a[n//2][n//2]
Q.append((n//2,n//2))
L=0
while True:
    if L == n//2:
        break
    size=len(Q)
    for i in range(size):
        tmp = Q.popleft()
        for j in range(4):
            x = tmp[0] + dx[j]
            y = tmp[1] + dy[j]
            if ch[x][y] == 0:
                sum+=a[x][y]
                ch[x][y] = 1
                Q.append((x,y))
    L+=1
print(sum)

            
