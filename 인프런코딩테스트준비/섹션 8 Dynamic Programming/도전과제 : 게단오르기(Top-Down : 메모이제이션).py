def DFS(l):
    if M[l] > 0:
        return M[l]
        
    if l == 1 or l == 2:
        return l
    else:
        M[l] = DFS(l-1) + DFS(l-2)
        return M[l]


n = int(input())
M = [0] * (n+1)
print(DFS(n))