""" 내가 짠 코드 """
s1 = input()
s2 = input()
L1=[]
L2=[]
for i in range(len(s1)):
    L1.append(s1[i])
for i in range(len(s2)):
    L2.append(s2[i])
for i in range(len(L1)):
    for j in range(len(L2)):
        if L1[i] == L2[j]:
            L2.pop(j)
            break
if len(L2)==0:
    print("YES")
else:
    print("NO")

""" 강의 선생님이 짠 코드"""

# a = input()
# b = input()
# str1 = dict()
# str2 = dict()

# for x in a:
#     str1[x] = str1.get(x,0) + 1
# for x in b:
#     str2[x] = str2.get(x,0) + 1

# for i in str1.keys():
#     if i in str2.keys():
#         if str1[i] != str2[i]: # key 값의 value 즉 알파벳의 갯수를 확인
#             print("NO")
#             break
#     else:
#         print("NO")
#         break
# else: # 정상적으로 포문이 끝나면
#     print("YES")

