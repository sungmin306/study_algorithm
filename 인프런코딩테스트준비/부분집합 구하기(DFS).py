def DFS(v):
    if v == n + 1:
        for i in range(1, n+1):
            if ch[i] == 1:
                print(i, end=' ')
        print()

    else:
        ch[v] = 1  # 노드값이 들어갈때 1
        DFS(v+1)
        ch[v] = 0  # 노드값이 들어가지 않을 때 0
        DFS(v+1)


n = int(input())
ch = [0]*(n+1)  # check변수
DFS(1)
