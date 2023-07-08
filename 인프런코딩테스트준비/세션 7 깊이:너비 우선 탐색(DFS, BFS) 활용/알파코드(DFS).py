# 내 코드 (정답 x)
"""
import sys
def DFS(v):
    global cnt
    if v == len(S):
        for x in L:
            print(x,end='')
        print()
        cnt += 1
    else:
        if v == (len(S)-1):
            if S[v] == '0':
                tmp = int(ord(L.pop()))
                input_val = tmp*10 + S[v]
                L.append(chr(input_val))
                DFS(v+1)
                L.pop()
            else:
                L.append(chr(int(S[v]) + 64))
                DFS(v+1)
                L.pop()
                
            # if S[v] != '0':
            #     L.append(chr(int(S[v]) + 64)) 
            #     DFS(v+1)
            #     L.pop() # 시간복잡도 o(1)
        else:
            if S[v] == "0": # S[v] 의 값이 0일떄
                tmp = int(ord(L.pop()))
                input_val = tmp*10 + int(S[v])
                L.append(chr(input_val))
                DFS(v+1)
                L.pop()    
            else: #S[v] 의 값이 0이 아닐때
                if int(S[v] + S[v+1])<= 26: # 두개를 더했을 때 값이 26보다 작을때
                    # 값 1개만 넣을 때 
                    L.append(chr(int(S[v]) + 64)) # 아스키 고드 변환
                    DFS(v+1)
                    L.pop()
                    # 값 2개를 합쳐서 같이 넣을때
                    L.append(chr(int(S[v] + S[v+1])+ 64))
                    DFS(v+2)
                    L.pop()
                else: # 두개를 더했을 때, 값이 26보다 클때 
                    L.append(chr(int(S[v]) + 64))
                    DFS(v + 1)
                    L.pop()
                    



        #if S[v+1] != '0':
            # if int(S[v] + S[v+1]) <= 26:
            #     if S[v+1] =='0':
            #         L.append(chr(int(S[v]) + 64)) 
            #         DFS(v+2)
            #         L.pop()
            #     else:      

            #         L.append(chr(int(S[v]) + 64)) 
            #         DFS(v+1)
            #         L.pop()
            #         L.append(chr(int(S[v] + S[v+1]) + 64))
            #         DFS(v+2)
            #         L.pop()
            # else:
            #     L.append(chr(int(S[v]) + 64)) 
            #     DFS(v+1)
            #     L.pop()
        # else: # 다음 값이 0이면 앞에 값과 같이 연결함
        #     L.append(chr(int(S[v] + S[v+1]) + 64))
        #     DFS(v+2)
        #     L.pop()


        

S = input()
if S == '0':
    sys.exit(0)
L=[]
res = ''
cnt = 0
DFS(0)
print(cnt)
"""
import sys
def DFS(L,P):
    global cnt
    if L == n:
        cnt +=1
        for i in range(P):
            print(chr(res[i] + 64), end='')
        print()
    
    else:
        for i in range(1,27):
            if code[L]==i:
                res[P]=i
                DFS(L+1, P+1)
            elif i>=10 and code[L]==i//10 and code[L+1]==i%10:
                res[P]=i
                DFS(L+2, P+1)

code = list(map(int,input()))
n = len(code)
code.insert(n,-1) # list index out of range 방지 -> 참신한 방법인듯 알아둬야겠다
res = [0] * (n+3)
cnt = 0
DFS(0,0)
print(cnt)
