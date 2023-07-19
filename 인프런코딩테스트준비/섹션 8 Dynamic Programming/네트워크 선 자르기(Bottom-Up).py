# #일단 최근까지 DFS 문제를 풀어서 DFS 방식이 바로 생각나서 이걸로 품
import sys
sys.setrecursionlimit(10**6)
def DFS(n):
    global cnt
    if n == 0:
        cnt += 1
    elif n > 0:
        DFS(n -1)
        DFS(n-2)

n = int(input())
cnt = 0
DFS(n)
print(cnt)

# DP 방식
n = int(input())

DP= [0] * (n + 1)
DP[0] = 1
DP[1] = 1
for i in range(2,n+1):
    DP[i] = DP[i-1] + DP[i-2]
print(DP[n])

