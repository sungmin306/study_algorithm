def solution(food_times, k):
    answer = 0
    for i in range(k):
        answer += 1
        # answer 가 음식의 종류(len(food_times)) 보다 크게되면 음식의 순서를 다시 0으로 만들기
        if answer == len(food_times):
            answer = 0
        # 먹어야할 음식의 남은 시간이 0보다 클경우 음식 먹기
        if food_times[answer] > 0:
            food_times[answer] -= 1
        # 먹어야할 음식이 0일 경우 다음 음식이 0이 아닐때까지 패스한 후에 음식 먹기
        else:
            while food_times[answer] == 0:
                answer += 1
            food_times[answer] -= 1
    answer += 1
    if max(food_times) == 0:
        answer = 0
    return answer