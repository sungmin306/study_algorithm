n = int(input())
L = [list(map(int,input().split())) for _ in range(n)]
lt=n//2
rt=n//2+1
s=0 # sum
for i in range(n):
    if i< n//2:
        for j in range(lt,rt):
            s+=L[i][j]
        lt-=1
        rt+=1
    else:
        for j in range(lt,rt):
            s+=L[i][j]
        lt+=1
        rt-=1
print(s)



"""
선생님풀이
n=int(input())
a=[list(map(int, input().split())) for _ in range(n)]
res=0
s=e=n//2

for i in range(n):
    for j in range(s,e+1):
        res+=a[i][j]
    if i<n//2:
        s-=1
        e+=1
    else:
        s+=1
        e-=1

내 방법보다 코드도 훨씬 단순하고 간략하다
나느 좀 코드를 중복해서 적는데 이런식으로 하려고 노력해야겠다.
"""


