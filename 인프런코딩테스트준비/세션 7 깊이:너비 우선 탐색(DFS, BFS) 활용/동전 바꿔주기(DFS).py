#내코드 (정답) but 정답이긴한데 타임어택 뜰듯 -> 5번째 줄로 해결
def DFS(v,s):
    #print("돌아가는중")
    global cnt
    if s < 0: # 가지치기 시간복잡도
        return
    if v == k:
        # print("조건문들어감")
        if s == 0:
            cnt += 1
    else:
        for i in range(n[v]+1):# i는 사용 할 동전의 개수
            # print("사용할 동전의 개수",i)
            # print("n[v]값",n[v])
            # print("v의 값",v)
            DFS(v+1,s- (i * p[v])) 


t = int(input())
k = int(input())
p=[] # 값
n=[] # 개수
cnt=0
for i in range(k):
    a, b = map(int,input().split())
    p.append(a)
    n.append(b)
DFS(0,t)
print(cnt)

# 선생님코드
"""
import sys
sys.stdin=open("input.txt", "r")
def DFS(L, sum):
    global cnt
    if sum>m:
        return
    if L==n:
        if sum==m:
            cnt+=1
    else:
        for i in range(cn[L]+1):
            DFS(L+1, sum+(cv[L]*i))

m=int(input())
n=int(input())
cv=list()
cn=list()
for i in range(n):
    a, b=map(int, input().split())
    cv.append(a)
    cn.append(b)
cnt=0
DFS(0, 0)
print(cnt)
"""