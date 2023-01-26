n, m = map(int,input().split())
L=list(map(int,input().split()))

# cnt=0
# L.sort()
# for i in L1:
#     cnt+=1
#     if i == m:
#         break
# print(cnt) 


# 위 풀이는 맞으나 하나씩 비교를 했기에 강의에 배운 이분 탐색을 활용해서 코드다시짜보기
L.sort()
lt=0 # 왼쪽 포인터
rt=n-1 # 오른쪽 포인터
while lt<=rt: # lt가 작거나 같을때까지 반복
    mid = (lt+rt) // 2
    if L[mid] == m:
        print(mid+1)
        break
    elif L[mid] > m:
        rt = mid-1
    else:
        lt = mid + 1












"""
n, m=map(int, input().split())
a=list(map(int, input().split()))
a.sort()
lt=0
rt=n-1
while lt<=rt:
    mid=(lt+rt)//2
    if a[mid]==m:
        print(mid+1)
        break
    elif a[mid]>m:
        rt=mid-1
    else:
        lt=mid+1
"""