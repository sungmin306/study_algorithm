L=[list(map(int,input().split())) for _ in range(9)]

L1=[1,2,3,4,5,6,7,8,9]
L2=[1,2,3,4,5,6,7,8,9]

check=0
s1=s2=s3=0
for i in range(9):
    for j in range(9):
        s1+=L[i][j]
        s2+=L[j][i]
        if i % 3 ==1 and j % 3 == 1: # 행이 1,4,7 행면서 열이 1,4,7 열 일때
            s3 = L[i][j] + L[i+1][j] + L[i-1][j] + L[i][j+1] + L[i][j-1] + L[i-1][j-1] + L[i-1][j+1] + L[i+1][j-1] + L[i+1][j+1]
    #         print("{} = s3".format(s3))
    # print("{} = s1".format(s1))
    # print("{} = s2".format(s2))

    if s1 ==45 and s2 == 45 and s3 == 45: # 45까지의 합
        check=1
    s1=s2=s3=0
# print(check)
if check == 0:
    print("No")
elif check == 1:
    print("YES")


# 1~9까지의 합 = 45 라는 생각으로 풀었는데 생각해보니 1 2 대신 2 2 8 9 대신 9 9 로 해서 해도 45 나옴;; 방향성 잘못됨
# 처음 생각해 낸 방식으로 리스트 팝하는 식으로 해야할꺼같은데 이럼 3중 for문으로 시간 오래걸림 - > O(n^3)이기에 시도 안해봄 일단 선생님 문제 보고 해야할듯

"""
선생님코드
3중포문을 돌릴 수 밖에 없다고 함;; -> 결론은 일단 앞으로 3중 for문 생각하지말고 코드짜는게 우선인듯 -> 특히 소마 코테일때는 더더욱 확실한 방법으로 시도하자 시간은 일단 신경 쓰지말고
def check(a):
    for i in range(9):
        ch1=[0]*10
        ch2=[0]*10
        for j in range(9):
            ch1[a[i][j]]=1
            ch2[a[j][i]]=1
        if sum(ch1)!=9 or sum(ch2)!=9:
            return False
    for i in range(3):
        for j in range(3):
            ch3=[0]*10
            for k in range(3):
                for s in range(3):
                    ch3[a[i*3+k][j*3+s]]=1
            if sum(ch3)!=9:
                return False
    return True

a=[list(map(int, input().split())) for _ in range(9)]
if check(a):
    print("YES")
else:
    print("NO")
"""



