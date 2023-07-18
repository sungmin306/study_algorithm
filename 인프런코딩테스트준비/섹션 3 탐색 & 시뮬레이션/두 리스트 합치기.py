# 내가 푼 문제풀이 sort 이용
n= int(input())
L1=[]
L1= list(map(int, input().split()))
#L1.sort() # 오름차순 정렬
m = int(input())
L2 = list(map(int, input().split()))
#L2.sort() # 오름차순 정렬
cnt  = 0 
L3=[]
L3= L1 + L2 # -> 리스트 합치기가 가능 합니다
L3.sort()
for i in range(len(L3)):
    print(L3[i], end=" ")
print("")

# 예시처럼 이미 정렬되어있으면 sort를 이용하면 nlogn 이 걸리는데 n 번으로 시간복잡도를 줄일 수 있다.

'''
선생님 답
두 지점을 가리키는 변수를 이용하자!
n= int(input())
L1= list(map(int, input().split()))
m = int(input())
L2 = list(map(int, input().split()))
p1=p2=0
while p1<n and p2<m:
    if L1[p1] <= L2[p2]:
        L3.append(L1[p1])
        p1+=1
    else:
        L3.append(L2[p2])
        p2+=1
if p1<n:
    L3=L3+l1[p1:]
if p2<m:
    L3=L3+L2[p2:]
for i in range(lent(L3)):
    print(L3[i], end=" ")
print("")

포인터처럼 가리키는 걸 생각을 못했는데 생각하려고 노력해보자
    

'''