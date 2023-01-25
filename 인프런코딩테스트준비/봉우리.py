n = int(input())
L=[list(map(int,input().split())) for _ in range(n)]

cnt = 0
check1 = 0
check2 = 0
for i in range(n):
    for j in range(n):
        a = L[i][j]
        if 0<j<n-1:
            lp = L[i][j-1]
            rp = L[i][j+1]
        elif j == 0:
            lp = 0
            rp = L[i][j+1]
        elif j == n-1:
            lp = L[i][j-1]
            rp = 0
        if a>lp and a>rp:
            check1 = 1
        if 0<i<n-1:   
            up = L[i-1][j]
            dp = L[i+1][j]
        elif i == 0:
            up = 0
            dp = L[i+1][j]
        elif i == n-1:
            up = L[i-1][j]
            dp = 0
        if a>up and a>dp:
            check2 = 1
        if check1==check2==1:
            cnt+=1
        check1=0
        check2=0
print(cnt)

'''
선생님 코드
나랑 다르게 실제로 0을 insert해서 문제를 풀었다 -> 내가 insert를 거의 안써봐서 이거 생각 못했음
n=int(input())
a=[list(map(int,input().split())) for _ in range(n)]
a.insert(0,[0]*n) # 위에 0 넣기
a.append([0]*n)

#이런식으로 해서 상하좌우 비교가능
dx=[-1,0,1,0]
dy=[0,1,0,-1]
for x in a: # 가장 자리 0 입력
    x.insert(0,0)
    x.append(0)
cnt=0
for i in range(1,n+1):
    for j in range(1,n+1):
        if all(a[i][j]>a[i+dx[k]][j+dy[k]] for k in range(4)): #all()은 모든게 참이어야 만족하는 함수 이런식으로 코딩 가능
        cnt+=1
    
        

'''





