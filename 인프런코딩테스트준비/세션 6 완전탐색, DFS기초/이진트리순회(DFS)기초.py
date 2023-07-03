# DFS, 전위순위, 중위순위, 후위순위 구현 및 연습

def DFS(v):
    if v > 7:
        return
    else:
        print(v, end=" ")  # 순회 방문 (여기서 하면 전위 순위 방식)
        print()
        DFS(v*2)  # 왼쪽 자식 노드 호출
        print(v, end=" ")  # 순회 방문 (여기서 하면 중위 순위 방식)
        DFS(v*2+1)  # 오른쪽 자식 노드 호출
        print(v, end=" ")  # 순회 방문 (여기서 하면 후위 순위 방식) -> 대표적인게 병합정렬임


# main
DFS(1)
