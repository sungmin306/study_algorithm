
def binary_number(n,L):
    if n == 0:
        return L
    d = n // 2
    input_num = n % 2
    L.append(input_num)
    #print(L)
    return binary_number(d,L)

n = int(input())
L=[]
B=[]
B=binary_number(n,L)
#print(len(B))

for i in range(len(B)-1,-1,-1):
    print(B[i],end="")
print("") 