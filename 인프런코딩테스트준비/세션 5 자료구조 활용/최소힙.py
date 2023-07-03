import heapq as hq
a=[] # 빈 리스트
while True:
    n=int(input())
    if n == -1:
        break
    if n == 0:
        if len(a)==0:
            print(-1)
        else:
            print(hq.heappop(a))
    else:
        hq.heappush(a,n)
        
