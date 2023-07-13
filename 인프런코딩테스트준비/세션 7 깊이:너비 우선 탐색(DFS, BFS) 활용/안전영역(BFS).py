from collections import deque
import copy
n = int(input())
L = [list(map(int,input().split())) for _ in range(n)]
dx = [-1,0,1,0] # 좌우
dy = [0,1,0,-1] # 상하
Q=deque()
#max_value = max(L) # 이렇게하면 리스트가 나옴 리스트0번쨰 index만앞에서만 비교
max_value = max(map(max, L))
#print(max_value)
#print(max_value)
#min_value = min(L)
min_value = min(map(min,L))
#print(min_value)
res = 0
for h in range(min_value,max_value +1): # 지역의 제일 낮은 높이부터 제일 높은 높이만 비온다고 확인
    #ch = [row[:] for row in L] # L리스트 복사하는 법 
    ch = copy.deepcopy(L)
    # ch = []
    # ch = L # 이렇게하면 L도 변경됨 -> 이유는 잘 모르곘네..
    #print(ch) 
    cnt = 0
    for i in range(n):
        for j in range(n):
            if ch[i][j] > h:
                ch[i][j] = 0 # 체크했으므로 중복 체크 금지하게 하려고 0으로 바꿈
                Q.append((i,j))
                while Q: # 안전구역 어디까지인지 확인하는 while문
                    tmp = Q.popleft()
                    for k in range(4):
                        x = tmp[0] + dx[k]
                        y = tmp[1] + dy[k]
                        if 0<= x < n and 0<= y < n and ch[x][y] > h:
                            ch[x][y] = 0 # 안전영역인것을 확인했기 때문에 0으로 바꿈
                            Q.append((x,y))
                cnt +=1
    res = max(res,cnt)
print(res)

#### 선새님 코드
"""
import sys
sys.stdin=open("input.txt", "r")
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
sys.setrecursionlimit(10**6) # 자동으로 재귀 종료 얘도 알아두자
def DFS(x, y, h):
    ch[x][y]=1
    for i in range(4):
        xx=x+dx[i]
        yy=y+dy[i]
        if 0<=xx<n and 0<=yy<n and ch[xx][yy]==0 and board[xx][yy]>h:
            DFS(xx, yy, h)

if __name__=="__main__":
    n = int(input())
    cnt = 0
    res = 0
    board=[list(map(int, input().split())) for _ in range(n)]
    for h in range(100):
        ch=[[0]*n for _ in range(n)]
        cnt=0
        for i in range(n):
            for j in range(n):
                if ch[i][j]==0 and board[i][j]>h:
                    cnt+=1
                    DFS(i, j, h)
        res=max(res, cnt)
        if cnt==0: # 최대 높이 이후로는 반복문 돌릴 필요 없으므로 설정함
            break
    print(res)
"""




    

    

                    
                    
                
    