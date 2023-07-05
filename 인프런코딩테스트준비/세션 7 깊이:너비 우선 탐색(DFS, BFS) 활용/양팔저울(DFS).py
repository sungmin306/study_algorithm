# 내 코드 정답
def DFS(v,r):
    if v == k + 1:
        # L2=[]
        # for i in range(1,k + 1):
        #     if ch[i] == 1:
        #             L2.append(-1 * L[i])
        #     elif ch[i] == 0:
        #         L2.append(L[i])
        # print("L2안에 들어간 값은",L2)
        # a = sum(L2)
        # #print(a)
        # if a >= 0:
        #     print(a)
        #     ch2[a] = 1
        if r > 0:
            ch2[r] = 1
    else:
        ch[v] = 1  # 왼쪽으로 들어갈때
        DFS(v+1,r+(-1 * L[v]))
        ch[v] = 0  # 오른쪽으로 들어갈 때
        DFS(v+1, r + L[v])
        ch[v] = -1 # 안들어갈때
        DFS(v+1, r)

k = int(input())
L=list(map(int,input().split()))
s = sum(L)
L.insert(0,'x')
ch=[0] * (k + 1) # L에 대칭인 check 리스트
ch2=[0] * (s + 1)
DFS(1,0)
cnt = 0
for i in range(1,len(ch2)): # len() 함수의 시간복잡도는 O(1) 이므로 사용해도 무관
    if ch2[i] != 1:
        cnt += 1
print(cnt)
#print(ch2)

# 선생님 코드
# import sys
# sys.stdin=open("input.txt", "r")
# def DFS(L, sum):
#     global res
#     if L==n:
#         if 0<sum<=s:
#             res.add(sum)
#     else:
#         DFS(L+1, sum+G[L])
#         DFS(L+1, sum-G[L])
#         DFS(L+1, sum)

# if __name__=="__main__":
#     n=int(input())
#     G=list(map(int, input().split()))
#     s=sum(G)
#     res=set()
#     DFS(0, 0)
#     print(s-len(res))
  

