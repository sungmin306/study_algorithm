
# 내코드 (정답)
def DFS(h, m):
    global cnt
    # cnt = cnt + 1

    if h >= cnt:  # timeout 방지
        return
    if m < 0:
        return
    elif m == 0:
        if cnt > h:
            cnt = h

    else:
        for i in range(n):
            DFS(h+1, m-L[i])


# main
n = int(input())
L = list(map(int, input().split()))
L = sorted(L, reverse=True)
print(L)
m = int(input())
cnt = 9999999999  # 최소 동전 개수
sum = 0
DFS(0, m)
print(cnt)


"""
# 선생님 코드


def DFS(L, sum):
    if L > res: # timeout  방지
        return
    if sum > m:
        return
    if sum == m:
        if L < res:
            res = L
    else:
        for i in range(n):
            DFS(L+1, sum+a[i])


n = int(input())
a = list(map(int, input().split()))
m = int(input())
res = 214700000
a.sort(reverse=True)
DFS(0, 0)
"""
