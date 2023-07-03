n = int(input())
L=[]
for i in range(n):
    s = input()
    L.append(s)

for i in range(n-1):
    #print(L)
    s2 = input()
    for j  in range(len(L)):
        #print(j)
        if s2 == L[j]:
            L.pop(j)
            break

print(L[0])
    
"""아래는 강의 선생님 코드 dict 활용"""
# n = int(input())
# p=dict()
# for i in range(n):
#     word = input()
#     p[word] = 1 
# for i in range(n-1):
#     word=input()
#     p[word] = 0
# for key,value in p.items(): # items 활용해서 둘다 접근 가능
#     if value == 1:
#         print(key)
