# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    # Implement your solution here
    stack = []
    L = S.split() # S를 공백으로 나눔

    for i in L:
        if i.isdigit():
            if int(i) > 2**20 -1:
                return -1
            stack.append(int(i))
        elif i == "POP":
            if len(stack) < 1:
                return -1
            stack.pop()
        elif i == "DUP":
            if len(stack) < 1:
                return -1
            stack.append(stack[-1])
        elif i == "+":
            if len(stack) < 2:
                return-1
            n1 = stack.pop()
            n2 = stack.pop()
            s = n1 + n2
            if s> 2**20 - 1:
                return -1
            stack.append(s)
        elif i == "-":
            if len(stack) < 2:
                return -1
            n1 = stack.pop()
            n2 = stack.pop()
            d = n1 - n2
            if d < 0:
                return -1
            stack.append(d)
    if len(stack) == 0:
        return -1
    return stack[-1]

print(solution("4 5 6 - 7 +"))  # 출력: 8
print(solution("13 DUP 4 POP 5 DUP + DUP + -"))  # 출력: 7
print(solution("5 6 + -"))  # 출력: -1
print(solution("3 DUP 5 - -"))  # 출력: -1
print(solution("1048575 DUP +"))  # 출력: -1
