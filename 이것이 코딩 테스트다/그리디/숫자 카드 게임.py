n , m = map(int,input().split())
L=[]
for i in range(n):
    M = list(map(int,input().split()))
    L.append(M)

for i in range(n):
    mmin=999999
    mmax = 0
    for j in range(m):
        comp = min(mmin,L[i][j])
        mmin = comp
        #print("comp값은",comp)
    result = max(mmax,comp)
    mmax = result
print(result)
    