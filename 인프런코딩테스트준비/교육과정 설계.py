s = input()
n = int(input())
L=[]
for i in range(n):
    a = input()
    b = ""
    for j in range(n):
        for k in range(len(s)):
            if a[j] == s[k]:
                b+=a[j]

    if s == b:
        L.append('YES')
    else:
        L.append("NO")

for i in range(len(L)):
    print("#{0} {1}".format(i+1,L[i]))