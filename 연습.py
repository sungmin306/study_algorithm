def max_path_sum(grid):
    n = len(grid)
    print(n)

    # 기본적으로 grid를 복사하여 dp 배열을 초기화
    dp = [[0] * n for _ in range(n)]
    dp[0][0] = grid[0][0]

    # 첫 행 초기화
    for i in range(1, n):
        dp[0][i] = dp[0][i-1] + grid[0][i]

    # 첫 열 초기화
    for i in range(1, n):
        dp[i][0] = dp[i-1][0] + grid[i][0]

    # 나머지 부분 채우기
    for i in range(1, n):
        for j in range(1, n):
            dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]

    # 최대값 반환
    return dp[n-1][n-1]

# 테스트를 위한 격자판
grid = [
    [1, 1, 7],
    [-3, 4, -2],
    [9, 2, 3]
]

result = max_path_sum(grid)
print("최대 합:", result)


def add_number(a,b):
    result = a + b
    return result

sum_result = add_number(3,7)
print(sum_result)