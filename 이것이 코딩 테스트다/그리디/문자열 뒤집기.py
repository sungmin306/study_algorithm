s = input()
result = 0
com_val = s[0]
cnt = 0
for i in range(1,len(s)):
    if com_val != s[i]:
        cnt += 1
    com_val = s[i]
# print(cnt)
cnt = cnt + 1
result = cnt // 2
print(result)


#### 책 (내가 해볼려고 한 시도와 같음)
data = input()
count0 = 0
count1 = 0
if data[0] == "1":
    count0 += 1
else:
    count1 += 1

for i in range(len(data) - 1):
    if data[i] != data[i+1]:
        if data[i + 1] == "1":
            count0 += 1
        else:
            count1 += 1
print(min(count0,count1))
        
        
    