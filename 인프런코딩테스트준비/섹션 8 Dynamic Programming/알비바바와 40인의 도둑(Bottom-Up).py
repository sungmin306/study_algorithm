n = int(input())
L = [list(map(int,input().split())) for _ in range(n)]
DP = [[0]*n for _ in range(n)]
DP[0][0] = L[0][0]
for i in range(1,n):
    DP[0][i] = DP[0][i-1] + L[0][i]
for i in range(1,n):
    DP[i][0] = DP[i-1][0] + L[i][0]

for i in range(1,n):
    for j in range(1,n):
        if DP[i-1][j] <= DP[i][j-1]:
            DP[i][j] = DP[i-1][j] + L[i][j]
        else:
            DP[i][j] = DP[i][j-1] + L[i][j]
print(DP[n-1][n-1])
