n = int(input())
L=list(map(int,input().split()))
m = int(input())
L.sort()

# for i in range(m):
#     L[n-1] = L[n-1] - 1
#     L[0] = L[0] + 1
#     L.sort()
#print(L[n-1] - L[0])

L.sort(reverse=True)
#print(L)

for i in range(m):
    L[0] = L[0] - 1
    L[n-1] = L[n-1] + 1
    L.sort(reverse=True)
#    print(L)
#print(L) 
print(L[0]-L[n-1])
# 나 이거 sort(reverse=True) -> 이걸로 했는데 안됨.. 왜지..? -> 다시 하니까 나옴 내가 잘못 알고리즘을 짠듯 

"""
선생님 코드
L=int(input())
a=list(map(int, input().split()))
m=int(input())
a.sort()
for _ in range(m):
    a[0]+=1
    a[L-1]-=1
    a.sort()

print(a[L-1]-a[0])
"""


