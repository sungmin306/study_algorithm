# def DFS(v):
#     global L2, L3
#     if v == n + 1:
#         for i in range(n):
#             if ch[i] == 1:
#                 L2.append(L[i])
#         print(L2)
#         L3 = list(set(L) - set(L2))
#         if sum(L3) == sum(L2):
#             return 1
#         else:
#             L2 = []
#             L3 = []
#     else:
#         ch[v] = 1
#         DFS(v+1)
#         ch[v] = 0
#         DFS(v+1)


# n = int(input())  # n * n 리스트
# L = list(map(int, input().split()))
# print("L출력", L)
# L2 = []
# L3 = []
# ch = [0]*(n + 1)
# if (DFS(1) == 1):
#     print("YES")
# else:
#     print("No")

import sys


def DFS(L, sum):  # L은 인덱스 번호, sum은 부분집합 누적
    # if L==n:
    #     if sum==(total-sum):
    #         print("YES")
    #         sys.exit(0) # 프로그램을 아예 종료하는 코드
    # else:
    #     DFS(L+1,sum+a[L])
    #     DFS(L+1,sum)
    if L == n:
        if sum > total//2:  # 시간복잡도 줄일 수 있음
            return
        if sum == (total-sum):
            print("YES")
            sys.exit(0)  # 프로그램을 아예 종료하는 코드
    else:
        DFS(L+1, sum+a[L])
        DFS(L+1, sum)


n = int(input())
a = list(map(int, input().split()))
total = sum(a)
DFS(0, 0)
print("NO")  # sys.exit(0) 코드로 인해서 종료가 안될경우 NO가 프린트됨
