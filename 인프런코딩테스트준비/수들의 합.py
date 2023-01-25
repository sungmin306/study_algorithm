# n,m= map(int, input().split())
# L = list(map(int,input().split()))

# cnt=0
# s=0

# for i in range(n):
#     s+=L[i]
#     print("s={0}, L[i] ={1} 입니다".format(s,L[i]))
#     if s == m:
#         cnt+=1
#         if L[i] == m:
#             s=0
#         else:
#             s=L[i]

# print(cnt)


# 해결못함

# 선생님풀이 이론만 보고 풀었을때
# -> 포인터 를 이용해서 풀어라

n,m= map(int, input().split())
L = list(map(int,input().split()))

lt=0
rt=1
tot=L[0]
cnt=0

while True:
    if tot< m:
        if rt<n:
            tot+=L[rt]
            rt+=1
        else:
            break
    elif tot == m:
        cnt+=1
        tot-=L[lt]
        lt+=1
    else:
        tot-=L[lt]
        lt+=1
print(cnt)