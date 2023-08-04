n , m = map(int,input().split())
DP = [[10000] * (n+1) for _ in range(n+1)]
for i in range(n+1):
    DP[i][i] = 0
for _ in range(m):
    i , j , d = map(int,input().split())
    DP[i][j] = d    
for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            DP[i][j] = min(DP[i][j], DP[i][k] + DP[k][j])

for i in range(1,n+1):
    for j in range(1,n+1):
        if DP[i][j] == 10000:
            print("M",end=' ')
        else:
            print(DP[i][j],end=' ')
    print()
