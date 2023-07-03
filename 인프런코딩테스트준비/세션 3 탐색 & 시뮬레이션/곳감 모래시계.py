n = int(input()) # n * n 리스트
L = [list(map(int, input().split())) for _ in range(n)]
m = int(input())
L1 = [0]*n # 빈 리스트 생성
print(L1)
cnt = 0 # 리스트에 순서대로 값이 몇개씩 들어갔는지 저장하는 변수
#deque.rotate() -> 이거 사용하면 구현 가능하지만 일단 원리 구현 해보고 결정
for _ in range(m):
    a,b,c = map(int,input().split()) # a = 행번호 , b = 방향(왼쪽, 오른쪽), c = 회전하는 격자의 수
    
    for i in range(n):
        if b == 0: # 왼쪽 5
            if i+c < n:
                cnt+=1
                L1[i]=L[a-1][i+c]
            elif i+c >= n:
                L1[i]=L[a-1][i-cnt]
        elif b == 1: # 오른쪽
            if i+c < n: 
                cnt+=1
                L1[i+c]=L[a-1][i]
            elif i + c >= n:
                L1[i-cnt]=L[a-1][i]
    print(L1)
    print(L[a-1])
    #L[a-1] = L1 -> 이게 안되는 이유를 모르곘다
    for k in range(n):
        L[a-1][k] = L1[k]
    print(L)
    cnt = 0
    
print(L)
lt=0
rt=n
s=0
for i in range(n):
    if i < n//2:
        for j in range(lt,rt):
            s+=L[i][j]
        lt+=1
        rt-=1
    else:
        for j in range(lt,rt):
            s+=L[i][j]
        lt-=1
        rt+=1
print(s)
             

"""
n=int(input())
a=[list(map(int, input().split())) for _ in range(n)]
m=int(input())
for i in range(m):
    h, t, k = map(int, input().split())
    if t == 0:
        for _ in range(k):
            a[h-1].append(a[h-1].pop(0)) # 왼쪽 회전 효과
    else:
        for _ in range(k):
            a[h-1].insert(0, a[h-1].pop()) # 오른쪽 회전 효과
    
res=0
s=0
e=n-1
for i in range(n):
    for j in range(s, e+1):
        res+=a[i][j]
    if i<n//2:
        s+=1
        e-=1
    else:
        s-=1
        e+=1
print(res)

        
"""
