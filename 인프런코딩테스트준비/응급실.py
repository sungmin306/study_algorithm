from collections import deque
m , n = map(int,input().split())

deq= deque(map(int,input().split()))
com=deq[n]
cnt=0
while 1:
    # print("deq는 ", deq)
    # print("n값은 {}".format(n))
    tmp = deq.popleft()
    for i in range(len(deq)):
        if tmp < deq[i]:
            deq.append(tmp)
            if n > 0:
                n = n -1
            elif n == 0:
                n = len(deq) - 1
            break
    else:
        cnt+=1
        if n!=0:
            n = n-1
        else:
            print(cnt)
            break
