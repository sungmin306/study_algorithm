def DFS(x,y):
    if DP[x][y] > 0:
        return DP[x][y]
    if x == 0 and y == 0:
        return L[x][y]
    else:
        if y == 0:
            DP[x][y] = DFS(x-1,y) + L[x][y]
        elif x == 0:
            DP[x][y] = DFS(x,y-1) + L[x][y]
        else:
            DP[x][y] = min(DFS(x-1,y), DFS(x,y-1)) + L[x][y]
        return DP[x][y]
    
    

n = int(input())
L=[list(map(int,input().split())) for _ in range(n)]
DP=[[0] * n for _ in range(n)]
print(DFS(n-1,n-1))
