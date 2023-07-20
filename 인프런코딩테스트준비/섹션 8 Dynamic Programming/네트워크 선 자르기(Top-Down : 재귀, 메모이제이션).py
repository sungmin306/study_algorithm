#메모이제이션 -> 메모를 해서 불필요한 재귀호출을 방지
def DFS(len):
    if dy[len]>0:
        return dy[len] # 0이 아니면 기록된 값을 리턴해라 가지커트를 기록을 단축시킬 수 있다.
    if len == 1 or len == 2:
        return len
    else:
        dy[len] = DFS(len-1)+DFS(len-2)
        return dy[len]


n = int(input())
dy = [0] * (n+1)
print(DFS(n))