"""
아래 코드로 돌리면 테케 2번이 통과가 안됨 다른건 통과됨 -> 아직 문제 못 찾음
"""
# from collections import OrderedDict # 즁복된 문자 삭제하려고 가져옴
# s = input()
# n = int(input())
# L=[]
# for i in range(n):
#     a = input()
#     b = ""
#     for j in range(len(s)):
#         for k in range(len(a)):
#             if s[j] == a[k]:
#                 b+=s[j]
#     b = ''.join(OrderedDict.fromkeys(b))
#     #print(b)
#     if s == b:
#         L.append('YES')
#     else:
#         L.append("NO")
# #print(L)

# for i in range(len(L)):
#     print("#{0} {1}".format(i+1,L[i]))

from collections import deque

need = input()
n = int(input())
for i in range(n):
    plan = input()
    dq = deque(need)
    for x in plan: 
        if x in dq: # x 변수가 dq 안에 있는 경우
            if x != dq.popleft():
                print("#%d NO" %(i+1))
                break
    else:
        if len(dq) == 0:
            print("#%d YES" %(i+1))
        else:
            print("#%d NO" %(i+1))




    