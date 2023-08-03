n , m = map(int,input().split())
DP = [0] * (m+1) # DP 테이블 
for i in range(n):
    p , t = map(int,input().split())
    for j in range(m,t-1,-1):
        DP[j] = max(DP[j],DP[j-t]+p)
print(max(DP))