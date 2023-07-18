# 내코드 정답
from collections import deque
n = int(input())
L=[list(map(int,input().split())) for _ in range(n)]
#print(L)
dx = [0,-1,0,1]
dy = [1,0,-1,0]
dix = [1,1,-1,-1] # 대각선
diy = [-1,1,-1,1] # 대각선 
cnt = 0 # 섬 개수 카운트
Q = deque()
for i in range(n):
    for j in range(n):
        if L[i][j] == 1:
            L[i][j] = 0
            Q.append((i,j))
            while Q:
                tmp = Q.popleft()
                for k in range(4):
                    x = tmp[0] + dx[k] #상하좌우
                    y = tmp[1] + dy[k]
                    ix = tmp[0] + dix[k] #대각선
                    iy = tmp[1] + diy[k]
                    if 0<= x < n and 0<= y < n and L[x][y] == 1:
                        L[x][y] = 0
                        Q.append((x,y))
                    if  0<= ix < n and 0<= iy < n and L[ix][iy] == 1:
                        L[ix][iy] = 0
                        Q.append((ix,iy))
            cnt += 1
print(cnt)

#### 선생님코드
"""
import sys
from collections import deque
sys.stdin=open("input.txt", "r")
dx=[-1, -1, 0, 1, 1, 1, 0, -1]
dy=[0, 1, 1, 1, 0, -1, -1, -1]
n=int(input())
board=[list(map(int, input().split())) for _ in range(n)]
cnt=0
Q=deque()
for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            board[i][j]=0
            Q.append((i, j))
            while Q:
                tmp=Q.popleft()
                for k in range(8):
                    x=tmp[0]+dx[k]
                    y=tmp[1]+dy[k]
                    if 0<=x<n and 0<=y<n and board[x][y]==1:
                        board[x][y]=0
                        Q.append((x, y))
            cnt+=1
print(cnt)
"""

