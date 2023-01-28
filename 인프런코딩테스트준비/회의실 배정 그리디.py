import numpy as np
n = int(input())
S=[]
H=[]
for i in range(n):
    a, b =  map(int,input().split())
    S.append(a)
    H.append(b)
T=H
NS=[] # NEW_S
NH=np.sort(H) #NEW_H
NH_index = np.argsort(H)
NH=list(NH)
for i in range(n):
    NS.append(S[NH_index[i]])
# print(NS)
# print(NH)
c = NH[0] # compare
# print(c)
cnt=1
for i in range(1,n):
    if  c <= NS[i]:
        cnt+=1
        c=NH[i]
        # print(c)
print(cnt)
  
"""
선생님 코드
n=int(input())
meeting=[]
for i in range(n):
    a, b=map(int, input().split())
    meeting.append((a, b))
meeting.sort(key=lambda x : (x[1], x[0]))
et=0
cnt=0
for x, y in meeting:
    if x>=et:
        et=y
        cnt+=1
print(cnt)
"""


