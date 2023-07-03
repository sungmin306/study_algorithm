# def solution(S):
#     # Count the frequency of each digit in S
#     digit_counts = [0] * 10
#     for digit in S:
#         digit_counts[int(digit)] += 1

#     # Initialize the left half and right half of the palindromic number
#     left_half = ""
#     right_half = ""

#     # Find the largest digit that occurs an even number of times
#     for digit in range(9, -1, -1):
#         count = digit_counts[digit]
        
#         # Add half of the digits to the left and right halves
#         left_half += str(digit) * (count // 2)
#         right_half += str(digit) * (count // 2)

#     # Find the largest digit that occurs an odd number of times
#     middle_digit = ""
#     for digit in range(9, -1, -1):
#         count = digit_counts[digit]
        
#         # If there is an odd number of the current digit, set it as the middle digit
#         if count % 2 == 1:
#             middle_digit = str(digit)
#             break

#     # Return the largest palindromic number as a string
#     return left_half + middle_digit + right_half

def solution(S):
    # Implement your solution here

    L=[0] * 10 # 빈도수 체크 리스트
    return_string = ""
    left_string= ""
    right_string = ""
    for i in S:
        L[int(i)] += 1

    for i in range(9,0,-1):
            
            left_string += str(i) * (L[i] // 2)
            print(left_string)
            right_string += str(i) * (L[i] // 2) 
    
    
    center_string = ""
    for i in range(9,-1,-1):
        if L[i] % 2 == 1:
            center_string = str(i)
            print("center 값",center_string)
            break
    
    return_string = left_string + center_string + right_string
    return return_string


# S = "39878"
# result = solution(S)
# print(result)  # 출력: "898"

S = "00900"
result = solution(S)
print(result)  # 출력: "9"

# S = "0000"
# result = solution(S)
# print(result)  # 출력: "0"

# S = "54321"
# result = solution(S)
# print(result)  # 출력: "5"

# S= "44441"
# result = solution(S)
# print(result)

# S= "9993331"
# result = solution(S)
# print(result)

