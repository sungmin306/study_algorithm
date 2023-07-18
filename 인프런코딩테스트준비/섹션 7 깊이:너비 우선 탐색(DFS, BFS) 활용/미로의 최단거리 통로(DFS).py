# 내 코드 정답
def DFS(x,y):
    global cnt
    if x  == 6 and y == 6:
        cnt += 1
    else:
        for i in range(4):
            nx = x + dx[i] # new x
            ny = y + dy[i] # new y
            if 0<=nx<=6 and 0<=ny<=6 and L[nx][ny] == 0 and dis[nx][ny] == 0 : # index 에러 방지 & 벽인지 도로인지 확인
                dis[nx][ny] = 1
                DFS(nx,ny)
                dis[nx][ny] = 0

    


#### main
L = [list(map(int,input().split())) for _ in range(7)]
#L=[0][0] == 1
dis =[[0]*7 for _ in range(7)]
dis[0][0] = 1  
cnt = 0
dx = [-1,0,1,0]
dy = [0,1,0,-1]
DFS(0,0)
print(cnt)

#### 선생님 코드
"""
import sys
from collections import deque
#sys.stdin=open("input.txt", "r")
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
def DFS(x, y):
    global cnt
    if x==6 and y==6:
        cnt+=1
    else:
        for i in range(4):
            xx=x+dx[i]
            yy=y+dy[i]
            if 0<=xx<=6 and 0<=yy<=6 and board[xx][yy]==0:
                board[xx][yy]=1
                DFS(xx, yy)
                board[xx][yy]=0


board=[list(map(int, input().split())) for _ in range(7)]
cnt=0
board[0][0]=1
DFS(0, 0)
print(cnt)
"""