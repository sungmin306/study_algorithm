n = int(input())
L = []
for i in range(n):
    a,h,w = map(int,input().split())
    L.append([a,h,w])
# print(L)
L.sort(reverse = True)
# print(L)
DP = [0] * n
DP[0] = L[0][1]
for i in range(1,n):
    check_value = L[i][2] # 맨 위에 올라가져 있는 벽돌
    tmp  = 0
    for j in range(i-1,-1,-1):
        if check_value < L[j][2] and DP[j] > tmp:
            tmp  = DP[j]
    DP[i] = tmp + L[i][1]
print(DP)
print(max(DP))

            



