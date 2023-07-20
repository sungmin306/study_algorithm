n = int(input())

DP= [0] * (n + 2)
DP[0] = 1
DP[1] = 1
for i in range(2,n+2):
    DP[i] = DP[i-1] + DP[i-2]
print(DP[n+1])
# print(DP)