# 내 코드 정답 x
"""
import sys
def DFS(n,l):
    global cnt
    if n == e:
        sys.exit(0) # 프로그램 실행 종료
    else:
       
        DFS(n + L[0], l+1)

s, e = map(int,input().split())
cnt = 0
L = [5,1,-1]
DFS(s,0)
"""
import sys
from collections import deque
MAX = 10000
ch = [0] * (MAX + 1)
dis = [0] * (MAX + 1)
n, m = map(int,input().split())
ch[n] = 1
dis[n] = 0
dq = deque()
dq.append(n)
while dq:
    now=dq.popleft()
    if now == m:
        break
    for next in (now - 1, now + 1, now +5):
        if 0< next <= MAX:
            if ch[next] == 0: # 한번 체크했는지 안했는지 확인
                dq.append(next) # 확인 후 그 값들을 순서대로 dq에 저장
                ch[next] = 1 # 저장한 후 그 값들을 다음 확인때 체크하지 않게 하기 위해서 1로 바꿈
                dis[next] = dis[now] + 1 # level이 몇 level 인지 확인
print(dis[m])