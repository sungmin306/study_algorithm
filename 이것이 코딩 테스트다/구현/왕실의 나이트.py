c = input()
result = 0
cnt = 0
dc = [1,-1,1,-1,2,-2,2,-2]
dy = [2,2,-2,-2,1,1,-1,-1]
L = list([0] * 8 for _ in range(8))
x = c[1]
c = ord(c[0]) - ord('a') # 수평
r = int(x) - 1  # 수직 r = int(c[1]) -1 ,<- 이렇게 하면 에러나는데 왜 에러나는지 모르겠음 
for i in range(8):
    com_c = c + dc[i]
    com_r = r + dy[i]
    if 0<= com_c <= 8 and 0<= com_r <= 8:
        result += 1  
print(result)
