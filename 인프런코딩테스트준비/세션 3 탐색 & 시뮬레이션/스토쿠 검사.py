def check(L):
    for i in range(9):
        L1=[0]*10
        L2=[0]*10
        for j in range(9):
            L1[L[i][j]]=1
            L2[L[j][i]]=1
        if sum(L1) != 9 or sum(L2) != 9:
            #print("첫번째 조건문 들어왔습니다.")
            return False
    for k in range(3):
        for s in range(3):
            L3=[0]*10
            for i in range(3):
                for j in range(3):
                    L3[L[k*0+i][s*0+j]] = 1
            if sum(L3) != 9:
                return False
    return True





L=[list(map(int,input().split())) for _ in range(9)]

if check(L):
    print("YES")
else:
    print("NO")

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