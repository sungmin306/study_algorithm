def solution(ft, k):
    answer = 0

    while k > 0 :
        a = k // (len(ft) - ft.count(0) )  # a는 K 에서 전체길이에서 0의 개수를 나눈 몫의 값 
        b = k % (len(ft) - ft.count(0) ) # b는 k 에서 전체길이에서 0을 개수를 나눈 나머지 값

        for i, j in zip(ft, range(len(ft))):
            if ft[j] != 0:
                ft[j] = i - a
                if ft[j] < 0:
                    b = b + abs(ft[j])
                    ft[j] = 0
            k = b

        if len(ft) - ft.count(0) ==0:  # 모든 음식을 다 먹었을 때
            return -1

        if k+1 <= len(ft) - ft.count(0):
            for i in ft:
                answer += 1
                if i !=0 :
                    k -= 1
                if k == -1:
                    return answer
                

"""
입력예시
food_times [3,1,2]
k 5
result 1
"""
print(solution([3,1,2],5))