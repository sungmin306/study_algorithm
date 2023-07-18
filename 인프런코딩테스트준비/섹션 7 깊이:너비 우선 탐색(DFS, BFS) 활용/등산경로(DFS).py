# 내 코드 정답
def DFS(x,y):
    global cnt
    if x == high[0][0] and y == high[0][1]:
        cnt += 1
    else:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < n and 0 <= ny < n and L[x][y] < L[nx][ny]:
                ch[nx][ny] = 1
                DFS(nx,ny)
                ch[nx][ny] = 0

#### main
dx = [-1,0,1,0]
dy = [0,1,0,-1]
n = int(input())
L = [list(map(int,input().split())) for _ in range(n)]
ch=[[0] * n for _ in range(n)]
low_val = 99999999999999
Low = [[0]*2]
high_val = 00000000000000
high = [[0]*2]
cnt = 0
for i in range(n):
    for j in range(n):
        if L[i][j] < low_val:
            low_val = L[i][j]
            Low[0][0] = i
            Low[0][1] = j
        
        if L[i][j] > high_val:
            high_val = L[i][j]
            high[0][0] = i
            high[0][1] = j
ch[Low[0][0]][Low[0][1]] = 1
DFS(Low[0][0],Low[0][1])
print(cnt)

