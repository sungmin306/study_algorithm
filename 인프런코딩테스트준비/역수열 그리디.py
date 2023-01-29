n = int(input())
L = list(map(int,input().split()))
T = [0] * n

for i in range(n):
    for j in range(n):
        if L[i]==0 and T[j] == 0:
            T[j] = i+1
            break
        elif T[j] == 0:
            L[i]-=1
for i in T:
    print(i,end=" ")
        



#실력부족으로 못풀었다.. 했던 코드에 알고리즘 오류가 존재한다
# n = int(input())
# L = list(map(int,input().split()))
# T = [0] * n
# for i in range(n):
#     p=0 # T의 리스트 값을 가리키는 point
#     cnt = 0 # 횟수 도는 변수
#     while cnt< L[i]:
#         if T[p] == 0 or T[p] > L[i]:
#             cnt +=1
#         p+=1
#     print(cnt)
#     for j in range(p,n):
#         if T[j] == 0:
#             T[j] = i+1
#             print(T)
#             break


# for i in T:
#     print(i,end=" ")




"""
#자기앞에 0 의 개수로 값을 리스트에 넣으면 된다.
선생님 코드
n=int(input())
a=list(map(int, input().split()))
seq=[0]*n
for i in range(n):
    for j in range(n):
        if(a[i]==0 and seq[j]==0):
            seq[j]=i+1
            break
        elif seq[j]==0:
            a[i]-=1

for x in seq:
    print(x, end=' ')
"""

        