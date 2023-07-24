n = int(input())
L = list(map(int,input().split()))
DP = [0] * n
DP[0] = 1

for i in range(1,n):
    a = L[i] # 이 값이 증가수열에서 마지막일때
    # print("a값은",a)
    maxx = 0
    for j in range(1,i):
        if a > L[j]:
            if maxx < DP[j] :
                maxx = DP[j]
    DP[i] = maxx + 1
    # print(DP)
print(max(DP))

            
