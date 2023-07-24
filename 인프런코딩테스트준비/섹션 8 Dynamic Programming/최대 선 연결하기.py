n = int(input())
L = list(map(int,input().split()))
DP = [0] * n
DP[0] = 1
res = 1
for i in range(1,n):
    a = L[i]
    max_value=0
    for j in range(1,i):
        if a > L[j]:
            if max_value < DP[j]:
                max_value = DP[j]
    DP[i] = max_value + 1
    if res < DP[i]:
        res = DP[i]
print(res)
    


