def Check(L,m):
    cnt = 1
    ep=L[0]
    for i in range(1,len(L)):
        d =L[i] -  ep
        if d >= m :
            cnt+=1
            ep = L[i]
    return cnt
        
n , c = map(int, input().split())
L=[]
for i in range(n):
    a = int(input())
    L.append(a)
L.sort()
lt = 0
rt = L[-1]
i=1
while lt<=rt:
    mid = (lt + rt) // 2
    #d =L[i] -  L[0]
    if Check(L,mid)<c:
        rt= mid - 1
    else:
        res = mid
        lt = mid + 1
    i+=1

print(res)


"""
선생님 코드
def Count(len):
    cnt=1
    ep=Line[0]
    for i in range(1, n):
        if Line[i]-ep>=len:
            cnt+=1
            ep=Line[i]
    return cnt

n, c=map(int, input().split())
Line=[]
for _ in range(n):
    tmp=int(input())
    Line.append(tmp)
Line.sort()
lt=1
rt=Line[n-1]
while lt<=rt:
    mid=(lt+rt)//2
    if Count(mid)>=c:
        res=mid
        lt=mid+1
    else:
        rt=mid-1

print(res)

"""

        

