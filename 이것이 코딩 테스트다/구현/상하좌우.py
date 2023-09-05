n = int(input())
a = input()
r = 1
c = 1
for i in range(len(a)):
    if a[i] != " ":
        #print("조건문통과")
        if a[i] == "R":
            n2 = c + 1
            if n2 >= 1 and n2 <= n:
                c = n2
        if a[i] == "L":
            n2 = c - 1
            if n2 >= 1 and n2 <= n:
                c = n2
        if a[i] == "U":
            n2 = r - 1
            if n2 >= 1 and n2 <= n:
                r = n2
        if a[i] == "D":
            n2 = r + 1
            if n2 >= 1 and n2 <= n:
                r = n2
print(r,c)

            
        
