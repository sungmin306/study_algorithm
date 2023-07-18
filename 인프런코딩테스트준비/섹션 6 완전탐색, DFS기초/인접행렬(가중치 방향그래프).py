n , m = map(int,input().split())
g = [[0 for j in range(n)] for i in range(n)]
for i in range(m):
    a, b, c = map(int,input().split())
    g[a-1][b-1]=c

for i in range(n):
    for j in range(n):
        print(g[i][j],end=' ')
    print()
    