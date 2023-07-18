n = int(input())

for i in range(n):
    s = input()
    #s = list(s.lower()) -> list 안해도됨
    s = s.lower()
    m = len(s)//2
    cnt = 0
    for j in range(m):
        if s[j] != s[len(s)-1-j]:
            print("#"+str(i+1)+" NO")
            cnt = 1
            break
    if cnt == 0:
        print("#"+str(i+1)+" YES")
    """    
    위 부분(if cnt == 0) 
    # else:
    #     print("#%d YES" %(i+1))
    이런식으로 고치면 cnt라는 변수 없이 for 문안에서 break 가 안되면 else를 실행함
    """
    

    '''
    문자열 슬라이싱
    s[::-1] -> print 하면 문자를 자동으로 거꾸로 돌려줌 
    이상태에서
    if s==s[::-1] 로 해도 됨 원래 문자랑 거꾸로 된 문자랑 비교
    '''
    

    