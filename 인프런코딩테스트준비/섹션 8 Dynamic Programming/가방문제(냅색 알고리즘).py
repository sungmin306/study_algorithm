n , m = map(int,input().split())
DP = [0] * (m + 1)
for i in range(n):
    w, v = map(int,input().split())
    for j in range(w,m+1):
        DP[j] = max(DP[j],DP[j-w] + v)
print(DP[m])
