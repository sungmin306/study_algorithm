from collections import deque as dq
n = int(input())
L = list(map(int,input().split()))
L.sort()
D=dq(L)
result = 0
while len(D) != 0:
    a = L.pop()
    for i in range(a):
        if len(D) == 0:
            break
        D.popleft()
    result += 1
print(result)
        

#### 교재 정답
n = int(input())
data = list(map(int,input().split()))
data.sort()
result = 0
count = 0

for i in data:
    count +=1
    if count >= i:
        result += 1
        count = 0
print(result)



