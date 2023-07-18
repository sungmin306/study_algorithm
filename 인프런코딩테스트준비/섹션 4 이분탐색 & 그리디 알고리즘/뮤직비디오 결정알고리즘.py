def Check(m,L):
    s = 0
    cnt=1
    for i in range(len(L)):
        if s + L[i] <= m:
            s+=L[i]
        else:
            cnt+=1
            s = L[i]
    # print("cnt = {}".format(cnt))
    return cnt


n , m = map(int,input().split())
L = list(map(int,input().split()))
lt = 1
rt = sum(L)
res = 0

while lt<=rt:
    mid = (lt+rt)//2

    if Check(mid,L) <= m:
        res = mid
        # print("res = {}".format(res))
        rt = mid -1
    else:
        lt = mid + 1
print(res)

"""
선생님 코드 
def Count(capacity):
    cnt=1
    sum=0
    for x in Music:
        if sum+x>capacity:
            cnt+=1
            sum=x
        else:
            sum+=x
    return cnt

n, m=map(int, input().split())
Music=list(map(int, input().split()))
maxx=max(Music)
lt=1
rt=sum(Music)
res=0
while lt<=rt:
    mid=(lt+rt)//2
    if mid>=maxx and Count(mid)<=m:
        res=mid
        rt=mid-1
    else:
        lt=mid+1
print(res)
"""

    