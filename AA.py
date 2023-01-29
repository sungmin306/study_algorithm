n = int(input())
L = list(map(int,input().split()))
T = [0] * n

for i in range(n):
    for j in range(n):
        if L[i]==0 and T[j] == 0:
            T[j] = i+1
            break
        elif T[j] == 0:
            L[i]-=1
for i in T:
    print(i,end=" ")
        