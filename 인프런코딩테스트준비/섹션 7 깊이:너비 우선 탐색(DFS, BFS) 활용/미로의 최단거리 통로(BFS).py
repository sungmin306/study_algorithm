# 내 코드 정답 x
"""
from collections import deque
L = [list(map(int,input().split())) for _ in range(7)]
ch = [[0] * 7 for _ in range(7)]
dx = [0,-1,0,1] 
dy = [-1,0,1,0] 
Q = deque()
Q.append((0,0))
ch[0][0] = 1
level = 0
com_value = 0

while True:
    print("")
    if Q[0] == (6,6):
        com_value = 1
        break
    if not Q: # Q가 비어있으면 -1 반환
        print(-1)
        break
    size = len(Q)
    for _ in range(size):
        tmp = Q.popleft()
        for i in range(4):
            x = tmp[0] + dx[i] 
            y = tmp[1] + dy[i] 
            if (x >= 0 and x <= 6) and (y>= 0 and y <= 6): #index 에러 방지
                if L[y][x] == 0 and ch[x][y] == 0:
                    print("x,y값",x,y)
                    print(L[x][y])
                    ch[x][y] = 1 # 한번만 들어가기
                    Q.append((x,y))
    level +=1
if com_value == 1:
    level = level + 1 # 마지막 도착 추가
    print(level)
"""
                
            
    
### GPT 코드
# from collections import deque

# L = [list(map(int, input().split())) for _ in range(7)]
# ch = [[0] * 7 for _ in range(7)]
# dx = [1, 0, -1, 0]  # 수정된 이동 방향 (우, 하, 좌, 상)
# dy = [0, 1, 0, -1]
# Q = deque()
# Q.append((0, 0))
# ch[0][0] = 1
# path_count = [[0] * 7 for _ in range(7)]  # 각 좌표까지 도달하는 경로의 수를 기록하는 2차원 배열

# while Q:
#     x, y = Q.popleft()
#     if x == 6 and y == 6:  # 목적지에 도착한 경우
#         break

#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]

#         if 0 <= nx < 7 and 0 <= ny < 7 and L[nx][ny] == 0:
#             if ch[nx][ny] == 0:  # 방문하지 않은 좌표인 경우
#                 ch[nx][ny] = 1
#                 Q.append((nx, ny))
#                 path_count[nx][ny] = path_count[x][y] + 1

# print(path_count[6][6] if path_count[6][6] != 0 else -1)

#### 선생님 코드
from collections import deque
dx = [-1,0,1,0]
dy = [0,1,0,-1]
board = [list(map(int,input().split())) for _ in range(7)]
dis = [[0]*7 for _ in range(7)]
Q=deque()
Q.append((0,0))
board[0][0]=1
while Q:
    tmp = Q.popleft()
    for i in range(4):
        x = tmp[0] + dx[i]
        y = tmp[1] + dy[i]
        if 0<= x <= 6 and 0<=y<=6 and board[x][y] == 0:
            board[x][y] = 1
            dis[x][y] = dis[tmp[0]][tmp[1]] + 1
            Q.append((x,y))
if dis[6][6] == 0:
    print(-1)
else:
    print(dis[6][6])
            
