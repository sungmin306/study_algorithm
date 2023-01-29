n=int(input())
L=list(map(int, input().split()))
li = 0
ri = n-1
last = 0
T=[] # temp
res=""
while li<=ri:
    if L[li] > last:
        T.append((L[li],"L"))
    if L[ri] > last:
        T.append((L[ri],"R"))
    T.sort()
    if len(T)==0:
        break
    else:
        res += T[0][1]
        last = T[0][0]
        if T[0][1] == "L":
            li +=1
        elif T[0][1] == "R":
            ri -=1
    T.clear()

print(len(res))
print(res)

    


# 내가 했을때 문제를 제대로 이해 하지 못해서 해결 못했음 -> 해결성공






























"""
선생님 코드
n=int(input())
a=list(map(int, input().split()))
lt=0
rt=n-1
last=0
res=""
tmp=[]
while lt<=rt:
    if a[lt]>last:
        tmp.append((a[lt], 'L'))
    if a[rt]>last:
        tmp.append((a[rt], 'R'))
    tmp.sort()
    if len(tmp)==0:
        break;
    else:
        res=res+tmp[0][1]
        last=tmp[0][0]
        if tmp[0][1]=='L':
            lt=lt+1
        else:
            rt=rt-1
    tmp.clear()

print(len(res))
print(res)
"""