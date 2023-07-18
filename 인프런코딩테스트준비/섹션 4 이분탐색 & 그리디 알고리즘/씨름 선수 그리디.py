n = int(input())
L=[]
for i in range(n):
    h, w =map(int,input().split())
    L.append((h,w))
cnt=0
for x,y in L:
    #print("x = {}".format(x))
    check_value = 0
    for i in range(n):
        if x < L[i][0] and y < L[i][1]:
            break
    else:
        cnt+=1
        
print(cnt)

# 정렬 후 검사하는게 좀 더 빠른거 같다
# 키로 정렬 후 몸무게 만 비교를 해서 하면 반복문 한번에 가능하다 O(N)에 가능
"""
선생님 코드
n=int(input())
body=[]
for i in range(n):
    a, b=map(int, input().split())
    body.append((a, b))
body.sort(reverse=True)
largest=0
cnt=0
for x, y in body:
    if y>largest:
        largest=y
        cnt+=1
print(cnt)
"""