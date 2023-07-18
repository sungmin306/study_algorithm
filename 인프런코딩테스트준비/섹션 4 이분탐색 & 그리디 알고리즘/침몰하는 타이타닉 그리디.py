n, m = map(int,input().split())

L = list(map(int,input().split()))
L.sort(reverse=True)
# print(L)
cnt=0
while len(L) >0:
    s=0
    s+=L[0]
    #L.pop(0)
    del L[0]
    # print(L)
    for i in range(len(L)):
        if s + L[i] <= m:
            # a=L.pop(i)
            # print(a)
            cnt+=1
            del L[i]
            break
    else: cnt+=1
print(cnt)



"""
선생님 코드
from collections import deque # deque 있는 라이브러리 불러옴
n, limit=map(int, input().split())
p=list(map(int, input().split()))
p.sort()
p=deque(p) # 앞에서도 빼고 넣을수 있고 뒤에서도 빼고 넣을 수 있음 list는 앞에꺼 빼면 전체가 앞으로 땡겨져서 비효율적
cnt=0
while p:
    if len(p)==1:
        cnt+=1
        break
    if p[0]+p[-1]>limit:
        p.pop()
        cnt+=1
    else:
        p.popleft() # 맨앞에꺼 뺄 수 있음 효율성 증가
        p.pop()
        cnt+=1
print(cnt)
"""

