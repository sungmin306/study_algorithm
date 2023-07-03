# # 내코드(x)
# def DFS(h,s):
#     global cnt
#     if h == m:
#         for i in range(m):
#             print(res[i],end=' ')
#         print()
#         cnt += 1
#     else:
#         for i in range(s, n+1):
#             if ch[i] == 0:
#                 ch[i] = 1
#                 res[h] = i
#                 DFS(h+1,s+1)
#                 ch[i] = 0

# #### main

# n , m = map(int,input().split())
# ch= [0] * (n + 1)
# res = [0] * m
# cnt = 0
# DFS(0,1) 


# 선생님 코드

def DFS(L,s):
    global cnt
    if L == m:
        for i in range(m):
            print(res[i],end=' ')
        print()
        cnt+=1
    else:
        for i in range(s,n+1):
            res[L] = i
            DFS(L+1, i+1)


n, m = map(int,input().split())
res = [0] * m
cnt = 0
DFS(0,1)
print(cnt)