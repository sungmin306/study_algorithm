"""
testcase 1, 2 까지는 성공 그 이후 x 
m , n = map(int,input().split())
#print("실행")
L = []
Q = []
for i in range(1,m+1):
    L.append(i)
#print(L)
while 1:
    Q.append(L.pop(0))
    #print("list L", L)
    #print("Queue Q", Q)
    if len(Q) == n:
        for i in range(n-1):
            L.append(Q.pop(0))
        Q.clear()
    if len(L) == 0:
    #    print("list L",L)
    #    print("list Q",Q)
        d = n // len(Q)
    #    print(d)
        print(Q[d])
        break
"""

# 수업 구현만 듣고 내가 해보기

from collections import deque

deq = deque()

m , n = map(int,input().split())

for i in range(1,m+1):
    deq.append(i)
while 1:
    if len(deq) == 1:
        print(deq[0])
        break
    for i in range(n-1):
        deq.append(deq.popleft())
        #print(deq)
    deq.popleft()

"""
처음에는 list를 두개 만들어서 맨첨에 다 넣고 하나는 Q로 활용하려고 했으나,
강의듣고보니 deque를 이용해 deque하나로 사용이 가능하다
최대한 list를 적게쓰면서 단순하게 짜려고 노력해야곘다.
"""
