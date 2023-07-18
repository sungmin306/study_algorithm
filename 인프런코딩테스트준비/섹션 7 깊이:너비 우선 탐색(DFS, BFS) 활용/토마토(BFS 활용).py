from collections import deque
import sys
m , n = map(int,input().split())
L = [list(map(int,input().split())) for _ in range(n)]
#print()
# max_value = max(map(max,L))
# min_value = min(map(min,L))
dx = [-1,0,1,0]
dy = [0,-1,0,1]
flag = 0
Q = deque()
days = 0
check = 0
for i in range(n):
    for j in range(m):
        if L[i][j] == 0:
            flag = 1 # 다 존재
            break

if flag == 0:
    print(0)
    check= -1
else:
    for i in range(n):
        for j in range(m):
            if L[i][j] == 1:
                Q.append((i,j,days))
    #print(Q)
    while Q:
        #print("while문돌았습니다")
        #print("while문 deque",Q)
        while Q[0][2] == days:
            tmp = Q.popleft()
            for i in range(4):
                x = tmp[0] + dx[i]
                y = tmp[1] + dy[i]
                #print("x값은",x)
                #print("y값은",y)
                if 0 <= x < n and 0<= y < m and L[x][y] == 0:
                    L[x][y] = 1
                    Q.append((x,y,days+1))
                    #print(Q)
            if not Q:
                break
        days +=1
if flag == 1:
    for i in range(n):
        for j in range(m):
            if L[i][j] == 0:
                check = 1
                break
        
if check == 0:
    print(days-1)
elif check == 1:
    print(-1)


#### 선생님 문제
"""
import sys
from collections import deque
#sys.stdin=open("input.txt", "r")
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
n, m=map(int, input().split())
board=[list(map(int, input().split())) for _ in range(m)]
Q=deque()
dis=[[0]*n for _ in range(m)]
for i in range(m):
    for j in range(n):
        if board[i][j]==1:
            Q.append((i, j))
while Q:
    x, y=Q.popleft()
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<m and 0<=ny<n and board[nx][ny]==0:
            board[nx][ny]=1
            dis[nx][ny]=dis[x][y]+1
            Q.append((nx, ny))
flag=1
for i in range(m):
    for j in range(n):
        if board[i][j]==0:
            flag=0
result=0
if flag==1:
    for i in range(m):
        for j in range(n):
            if dis[i][j]>result:
                result=dis[i][j]
    print(result)
else:
    print(-1)
"""