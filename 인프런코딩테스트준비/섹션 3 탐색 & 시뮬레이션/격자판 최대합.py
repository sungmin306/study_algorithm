n= int(input())

L = [list(map(int, input().split())) for _ in range(n)]
L1 = []
s=0
for i in range(n):
    for j in range(n):
        s+=L[i][j]
    L1.append(s)
    s=0

for i in range(n):
    for j in range(n):
        s+=L[j][i]
    L1.append(s)
    s=0

for i in range(n):
    s+=L[i][i]
L1.append(s)
s=0

#for i in reverse(range(n)):
for i in range(n-1,-1,-1):
    s+=L[i][i]
L1.append(s)

L1.sort()
print(L1[-1])


"""
선생님 문제풀이

n = int(input())
a=[list(map(int,input().split())) for _ in range(n)]
# 우리가 보는것처럼 볼려면
# for x in a:
#     print(x)
largest= - 214700000
for i in range(n):
    sum1=sum2=0
    for j in range(n):
        sum1+=a[i][j]
        sum2+=a[j][i]
    if sum1 > largest:
        largest = sum1
    if sum2 > largest:
        largest = sum2
sum1=sum2=0
for i in range(n):
    sum1+=a[i][i]
    sum2+=a[i][n-i-1]
if sum1 > largest:
    largest = sum1
if sum2 > largest:
    largest = sum2
"""