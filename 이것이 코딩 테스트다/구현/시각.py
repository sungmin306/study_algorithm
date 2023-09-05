n = int(input())
result = (45 * 15) + (15 * 60)
if 0 < n < 3:
    result = n * result
elif n >= 3:
    result = 3600 + (n-1) * result + result
print(result)

    
