# 내 코드 (정답)
"""
def DFS(h):
    global cnt
    flag = 1

    if h == m:
        for i in range(len(res)):
            for j in range(i+1, len(res)):
                if res[i] == res[j]:
                    flag = 0

        if flag == 1:
            for i in range(m):
                print(res[i], end=' ')
            print()
            cnt = cnt + 1

    else:
        for i in range(1, n+1):

            res[h] = i
            DFS(h+1)


# main
n, m = map(int, input().split())
res = [0] * m
cnt = 0
DFS(0)
print(cnt)
"""
# 나는 일단 다 확인하고 같은 값일때만 출력을 안하는 식으로 진행했는데
# 밑에 있는 코드는 중복순열일경우 넘어가지 체크 리스트를 활용해서 넘어가지 않게끔 가지치기를 진행함
# 아래 코드가 그래서 더 효율적임

# 선생님 코드
# 체크 리스트 활용해도 좋음


def DFS(L):
    global cnt
    if L == m:
        for i in range(m):
            print(res[i], end=' ')
        print()
        cnt += 1
    else:
        for i in range(1, n+1):
            if ch[i] == 0:
                ch[i] = 1
                res[L] = i
                DFS(L+1)
                # 호출하고 back한후 되돌아 오는 상황
                ch[i] = 0


n, m = map(int, input().split())
res = [0] * m
ch = [0] * (n+1)  # check list
cnt = 0
DFS(0)
print(cnt)
