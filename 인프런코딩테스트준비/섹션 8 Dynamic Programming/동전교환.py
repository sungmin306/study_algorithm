n = int(input())
L=list(map(int,input().split()))
m = int(input())
DP=[1000] * (m+1)
DP[0] = 0

for i in range(n):
    for j in range(L[i],m+1):
        DP[j] = min(DP[j-L[i]] + 1,DP[j])
    # print(DP)
print(DP[m])
