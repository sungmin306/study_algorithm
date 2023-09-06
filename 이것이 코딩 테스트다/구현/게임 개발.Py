n , m = map(int,input().split())
a,b,d = map(int,input().split())
L = list(list(map(int,input().split())) for _ in range(n))


dc = [0,1,0,-1]
dr = [-1,0,1,0]
result = 0
cnt = 0
while True:
    print("반복문돕니다.")
    if cnt == 4:
        break
    if cnt == 3:
        if L[a+dr[3]][b+dc[3]] == -1:
            cnt = 0
            L[a][b] = 1
            a = a + dr[3]
            b = b + dc[3]
        elif L[a+dr[3]][b+dc[3]] == 0:
            cnt = 0
            result +=1
            L[a][b] = -1
            a = a + dr[3]
            b = b + dc[3]
        else:
            cnt +=1
    else:
        for i in range(3):
            if L[a+dr[i]][b+dc[i]] == 0:
                L[a][b] = -1
                a = a + dr[i]
                b = b + dc[i]
                cnt = 0
                result +=1
                break
        else:
            cnt += 3
print(result)
    