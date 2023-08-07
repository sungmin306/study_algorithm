n = int(input())
DP=[[100]*(n+1) for _ in range(n+1)]
L=[0] * (n+1)
s= 100
for i in range(1,n+1):
    DP[i][i] = 0
while True:
    a , b = map(int,input().split())
    if a == -1 and b == -1:
        break
    else:
        DP[a][b] = 1
        DP[b][a] = 1

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            DP[i][j] = min(DP[i][j], DP[i][k] + DP[k][j])

for i in range(1,n+1):
    for j in range(1,n+1):
        L[i] = max(L[i], DP[i][j])
    s = min(s,L[i])
R = []
for i in range(1,n+1):
    if L[i] == s:
        R.append(i)
print(s, len(R))
for i in range(len(R)):
    print(R[i],end=' ')
print()



