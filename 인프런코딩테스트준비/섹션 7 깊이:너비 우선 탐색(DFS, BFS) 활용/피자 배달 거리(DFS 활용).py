def DFS(x,l):
    global res_dis
    if l == m:
        # 4개를 뽑아서 올때마다 거리 비교
        com_dis = 0
        # print("뽑힌 피자집",C)
        # print("집 위치",H)
        for i in range(len(H)):
            least_dis = 99999999
            for j in range(len(C)):
                # print(abs(H[i][0]-C[j][0]) + abs(H[i][1] -C[j][1]))
                if least_dis > abs(H[i][0]-C[j][0]) + abs(H[i][1] -C[j][1]):
                    least_dis = abs(H[i][0]-C[j][0]) + abs(H[i][1] -C[j][1])
            # print("least_dis 값",least_dis)
            com_dis += least_dis   
        if res_dis > com_dis:
            res_dis = com_dis
            # print("res_dis값", res_dis)
    else:
        for i in range(x,len(P)): # 전체 피자집중에서 m개 뽑기
            C[l] = P[i] 
            DFS(i+1,l+1)
#### main
n , m = map(int,input().split())
L = [list(map(int,input().split())) for _ in range(n)]
P = [] # 피자 저장 리스트
H = [] # 집 저장 리스트
res_dis = 9999999
C=[0] * m # 피자집 중에서 m개 고르는 list 
for i in range(n):
    for j in range(n):
        if L[i][j] == 1:
            H.append((i,j))
        elif L[i][j] == 2:
            P.append((i,j))
DFS(0,0)
print(res_dis)


# import sys
# sys.stdin=open("input.txt", "r")
# def DFS(L, s):
#     global res
#     if L==m:
#         sum=0
#         for j in range(len(hs)):
#             x1=hs[j][0]
#             y1=hs[j][1]
#             dis=2147000000
#             for x in cb:
#                 x2=pz[x][0]
#                 y2=pz[x][1]
#                 dis=min(dis, abs(x1-x2)+abs(y1-y2))
#             sum+=dis
#         if sum<res:
#             res=sum    
#     else:
#         for i in range(s, len(pz)):
#             cb[L]=i
#             DFS(L+1, i+1)
       
# if __name__=="__main__":
#     n, m=map(int, input().split())
#     board=[list(map(int, input().split())) for _ in range(n)]
#     hs=[]
#     pz=[]
#     cb=[0]*m
#     res=2147000000
#     for i in range(n):
#         for j in range(n):
#             if board[i][j]==1:
#                 hs.append((i, j))
#             elif board[i][j]==2:
#                 pz.append((i, j))
#     DFS(0, 0)
#     print(res)

