# 내 코드 (정답)
import sys
def DFS(x,y): # x는 세로 담당, y는 가로 담당
    #print(x,y)
    if x == 0:
        print(y)
        sys.exit(0)
    else:
        for i in range(3):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < 10 and 0 <= ny < 10 and L[nx][ny] == 1:
                L[nx][ny] = 0
                DFS(nx,ny)
                #L[nx][ny] = 1
                break # 좌 우 가 우선순위이기에 들어갈경우 상 은 따로 확인안해도됨
L = [list(map(int,input().split())) for _ in range(10)]
dx = [0,0,-1] 
dy = [-1,1,0] # 순서를 좌 우 상 으로 해서 좌우 먼저 확인하게 함
a = 0
for i in range(10):
    if L[9][i] == 2:
        a = i
        break
DFS(9,a)



#### 선생님 코드
"""
import sys
sys.stdin=open("input.txt", "r")
def DFS(x, y):
    ch[x][y]=1
    if x==0:
        print(y)
    else:
        if y-1>=0 and board[x][y-1]==1 and ch[x][y-1]==0:
            DFS(x, y-1)
        elif y+1<10 and board[x][y+1]==1 and ch[x][y+1]==0:
            DFS(x, y+1)
        else:
            DFS(x-1, y)


board=[list(map(int, input().split())) for _ in range(10)]
ch=[[0]*10 for _ in range(10)]
for y in range(10):
    if board[9][y]==2:
        DFS(9, y)
"""