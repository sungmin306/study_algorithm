s = input()
size = len(s)
z=''
for i in range(size): # for x  in s: 이렇게도 가능 
    if s[i].isdigit() : # 문자열에서 isdigit을 이용해서 정수만 뽑아낼 수 있음
        z += s[i]
z= z.lstrip("0") # lstrip을 활용해서 앞에 있는 0을 지워버림
z= int(z)  
print(z)
cnt = 0
for i in range(1,z+1):
    if z % i == 0:
        cnt += 1
print(cnt)


"""
첫자리 0 무시하는 다른 방법
res=0
for x in s:
    if x.isdecimal():
        res=res*10+int(x) -> 이런식으로 하면 0 없앨 수 있음
"""
