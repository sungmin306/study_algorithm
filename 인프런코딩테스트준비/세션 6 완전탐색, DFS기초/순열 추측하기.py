import sys

#### 내 코드
def DFS(h):
    L2 = []
    L3 = []
    if h == n:
        for i in range(n):
            L2.append(res[i])
            # print(res[i], end=' '):
        # print(L2)
        while len(L2) != 1:
            # print("while 문 들어감")
            # print(len(L2))
            # print(L2)
            for i in range(len(L2)-1):
                s = L2[i] + L2[i+1]
                L3.append(s)
            L2 = L3
            L3 = []
        if L2[0] == f:
            #    print("마지막 조건문에 들어옴")
            for i in range(len(res)):
                print(res[i], end=' ')
            print()
            sys.exit(0)  # 제일 작은 값부터 DFS하므로 찾는순간 종료

    else:
        for i in range(1, n+1):
            if ch[i] == 0:
                ch[i] = 1
                res[h] = i
                DFS(h+1)
                ch[i] = 0  # 백할때 0d으로 초기화


# main
n, f = map(int, input().split())
res = [0] * n
ch = [0] * (n+1)
L = []
DFS(0)

# 선생님 코드
# 이항계수 조합으로 증명했는데 조합 규칙을 못찾았다 -> 힘들어서 생각을 제대로 못했는데 선생님 설명보니까 이항게수 조합규칙으로 문제풀었다..


# import sys


# def DFS(L, sum):
#     if L == n and sum == f:
#         for x in p:
#             print(x, end=' ')
#         print()
#         sys.exit(0)
#     else:
#         for i in range(1, n+1):
#             if ch[i] == 0:
#                 ch[i] = 1
#                 p[L] = i
#                 DFS(L+1, sum+(p[L]*b[L]))
#                 ch[i] = 0


# if __name__ == "__main__":
#     n, f = map(int, input().split())
#     p = [0]*n
#     b = [1]*n
#     ch = [0]*(n+1)
#     for i in range(1, n):
#         b[i] = b[i-1]*(n-i)//i
#     DFS(0, 0)


"""
#### 순열 라이브러리 활용
import itertools as it
n,f = map(int,input().split())
b=[1] * n
cnt = 0
for i in range(1,n):
    b[i] = b[i-1]*(n-1)/i
a=list(range(1,n+1))
for tmp in it.permutations(a):
    sum = 0
    for L, x in enumerate(tmp):
        if sum == f:
            for x in tmp:
                print(x, end=' ')
            break # 맨 위 for문을 break
        

print(cnt)
"""