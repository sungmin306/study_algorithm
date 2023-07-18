# 내코드 수정
def DFS(x,y):
    global cnt
    cnt+=1
    L[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<= nx < n and 0 <= ny < n and L[nx][ny] == 1:
            DFS(nx,ny)
            
                 
#### main
n = int(input())
L = [list(map(int,input())) for _ in range(n)] # 입력란에 띄어쓰기 없기때문에 .split() 안해도됨
res=list()
dx = [1,0,-1,0]
dy = [0,1,0,-1]
for i in range(n):
    for j in range(n):
        if L[i][j] == 1:
            cnt = 0
            DFS(i,j)
            res.append(cnt)
            # print(res)
print(len(res))
res.sort()
for x in range(len(res)):
    print(res[x])

        
#### 선생님 코드 (BFS 버전)
"""
import sys
from collections import deque
sys.stdin=open("input.txt", "r")
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
n=int(input())
board=[list(map(int, input())) for _ in range(n)]
cnt=0
res=[]
Q=deque()
for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            board[i][j]=0
            Q.append((i, j))
            cnt=1
            while Q:
                tmp=Q.popleft()
                for k in range(4):
                    x=tmp[0]+dx[k]
                    y=tmp[1]+dy[k]
                    if x<0 or x>=n or y<0 or y>=n or board[x][y]==0:
                        continue
                    board[x][y]=0
                    Q.append((x, y))
                    cnt+=1
            res.append(cnt)

print(len(res))
res.sort()
for x in res:
    print(x)
"""
# n = int(input())
# L=[list(map(int,input().split())) for _ in range(n)]
# ch = [[0] * n for _ in range(n)]
# ch_bfs = [[0] * n for _ in range(n)]
# ch_bfs[0][0] = 1
# m = [[0] * n for _ in range(n)]
# check_value = 1
# ch[0][0] == 1
# dx = [1,0,-1,0]
# dy = [0,1,0,-1]
# cnt = 0
# Q = deque()

# if 0<= nx < n and 0 <= ny < n:
#     if L[nx][ny] == 1:
#         Q.append((nx,ny))
#         while Q:
#             tmp = Q.popleft()
#             for j in range(4):
#                 tnx = tmp[0][0] + dx[j] # 좌, 우
#                 tny = tmp[0][1] + dy[j] # 위, 아래
#                 if L[tnx][tny] == 1 and ch_bfs == 0:
#                     Q.append((tnx,tny))
#                     ch[tnx][tny] = check_value
#                 ch_bfs[tnx][tny] = 1 # bfs에서 값이 들어갔는지 안들어갔는지 확인
#         check_value += 1 # 문제 그림 2처럼 만들기 위해 단지마다 값을 다 1쓰고 while문이 끝나면 다음 단지에는 그보다 높은 값을 한개씩 증가
