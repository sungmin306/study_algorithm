n, m, k = map(int,input().split()) # m = 더하는 횟수 , ㅏ는
L=list(map(int,input().split()))
L.sort()
cnt = 0
s = 0 # s는 더한 합
while 1:
    a=L[-1]
    for i in range(k):
        if cnt == m:
            break
        s += a
        cnt+=1
    if cnt == m:
        break
    a=L[-2]
    s+=a
    cnt+=1
print(s)
    
        
        
#### 좀 더 효율적인 코드 (수학적 접근)
n , m, k = map(int,input().split())
data = list(map(int,input().split()))

data.sort()
first = data[n-1]
second=data[n-2]

count = int(m / k+1) * k
count += m % (k + 1)

result = 0
result += (count) * first
result += (m-count) * second
print(result)