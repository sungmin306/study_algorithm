n , m = map(int,input().split())
L = [list(map(int,input().split())) for _ in range(n)]
C = []
result = 0

tmp = L[0][0]

for i in range(0,n):
    cnt = 1
    for j in range(1,n):
        if tmp == L[i][j]:
            cnt += 1
        else:
            C.append(cnt)
            cnt = 1
        tmp = L[i][j]
    
    if cnt >= m:
        result += 1
C=[]
tmp = L[0][0]
for i in range(n):
    cnt = 1
    for j in range(1,n):
        if tmp == L[j][i]:
            cnt += 1
        else:
            C.append(cnt)
            cnt = 1
        tmp = L[i][j]
    if cnt >= m:
        result += 1
print(result)






