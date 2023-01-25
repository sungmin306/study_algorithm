L=list(range(1,21))
#print(L)
for i in range(10):
    n, m = map(int,input().split()) # 입력 받는거
    minus = m-n 
    N_L = L[n-1:m] #문자열 슬라이싱
    R_L = N_L[::-1] # 문자열 reverse 
    for j in range(minus+1):
        L[n-1+j] = R_L[j]
for i in L:
    print(i, end=' ')

'''
선생님 답
for _ in range(10): #-> 이런식으로 대입하는게 없으면 _ 로 하면 좋음
    s, e=map(int, input().split())
    for i in range((e-s+1)//2):
        a[s+i], a[e-i] = a[e-i], a[s+i]
a.pop(0)
for x in a:
    print(x, end=' ')
'''