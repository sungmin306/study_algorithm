n , k = map(int,input().split())
cnt = 0
while 1:
    while n % k == 0:
        n = n // k
        cnt += 1
    if n == 1:
        break
    if n % k != 0:
        n = n -1
        cnt+=1
print(cnt)

        
    


