#내 코드 (정답)

def DFS(h,s):
    global cnt
    if h == k:
        if sum(res) % m == 0:
            cnt += 1
    
    else:
        for i in range(s, len(L)):
            res[h] = L[i]
            DFS(h+1, i+1)


#### main
n , k = map(int,input().split())
L = list(map(int,input().split()))
m = int(input())
res = [0] * k
cnt = 0
DFS(0,0)
print(cnt)


# # 선생님 코드
# def DFS(L,s,sum):
#     global cnt
#     if L == k:
#         if sum % m == 0:
#             cnt+=1
#     else:
#         for i in range(s,n):
#             DFS(L+1,i+1,sum+a[i])

# n, k = map(int,input().split())
# a = list(map(int,input().split()))
# m = int(input())
# cnt = 0
# DFS(0,0,0)
# print(cnt)


#### 조합 라이브러리 활용
# import itertools as it
# n, k = map(int,input().split())
# a = list(map(int,input().split()))
# m = int(input())
# cnt = 0
# for x in it.combinations(a, k):
#     if sum(x) % m == 0:
#         cnt +=1
# print(cnt)



