k,n = map(int,input().split())
L=[0]*k
for i in range(k):
   L[i] = int(input())
max=0
#print(L)
for i in range(k): # 리스트 안에서 최대 값 찾기
    if max < L[i]:
        max = L[i]
lt=0
rt=max
res=0
while lt<=rt:
    cnt = 0
    mt = (lt+rt)//2
    for i in range(k):
        cnt += L[i] // mt
    # print("{}은 cnt".format(cnt))
    # print("{}은 mt".format(mt))
    # print("{}은 lt".format(lt))
    # print("{}은 rt".format(rt))
    if cnt>=n:
        res=mt
        lt = mt + 1
    else:
        rt = mt -1
print(res)
#무한 반복문에 빠짐

"""
선생님 코드def Count(len):
    cnt=0
    for x in Line:
        cnt+=(x//len)
    return cnt

k, n=map(int, input().split())
Line=[]
res=0
largest=0
for i in range(k):
    tmp=int(input())
    Line.append(tmp)
    largest=max(largest, tmp)
lt=1
rt=largest
while lt<=rt:
    mid=(lt+rt)//2
    if Count(mid)>=n:
        res=mid
        lt=mid+1
    else:
        rt=mid-1
print(res)


"""
        
        
        

 