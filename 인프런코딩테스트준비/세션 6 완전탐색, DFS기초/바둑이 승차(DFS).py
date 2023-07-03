# def DFS(i, sum):
#     global L2
#     if sum > c:
#         return
#     else:
#         L2.append(sum)
#         print(L2)
#         DFS(i+1, sum+L[i])
#         DFS(i+1, sum)


# # main
# c, n = map(int, input().split())
# L = []
# L2 = []
# for i in range(n):
#     x = int(input())
#     L.append(x)

# DFS(0, 0)
# L2.sort()
# print(L2)

# def DFS(v):
#     global L2
#     sum = 0
#     if v == n + 1:
#         for i in range(1, n+1):
#             if ch[i] == 1:
#                 sum = sum + L[i]
#         L2.append(sum)

#     else:
#         ch[v] = 1  # 노드값이 들어갈때 1
#         DFS(v+1)
#         ch[v] = 0  # 노드값이 들어가지 않을 때 0
#         DFS(v+1)


# c, n = map(int, input().split())
# L = []
# L2 = []
# ch = [0]*(n+1)  # check변수
# for i in range(n):
#     x = int(input())
#     L.append(x)
# DFS(0)


import sys
from collections import deque


def DFS(L, sum, tsum):
    global result
    if sum+(total-tsum) < result:  # (total-tsum)앞으로 판단해야할 바둑이들의 총무게
        return
    if sum > c:
        return
    if L == n:  # 종착지에 오면, 부분집합이 완성되면
        if sum > result:
            result = sum
    else:
        DFS(L+1, sum+a[L], tsum+a[L])
        DFS(L+1, sum, tsum+a[L])


c, n = map(int, input().split())
a = [0] * n
result = -1000000
for i in range(n):
    a[i] = int(input())
total = sum(a)
DFS(0, 0, 0)
print(result)
