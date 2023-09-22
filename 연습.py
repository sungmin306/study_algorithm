global r 
def dfs(c,x,l):
    global r
    if c == x:
        print(c)
        r = 1
        return
    if len(x) < l:
        return
    else:
        push_s = "b" * c.count('a')
        dfs(push_s + c + push_s, x, len(push_s+ c + push_s))
        dfs(c+'a',x,len(c+'a'))
        dfs('a'+c,x,len('a'+c))

def solution(a):
    global r
    answer = []
    for x in a:
        compare_string = 'a'
        r = 0
        length = len(x)
        dfs(compare_string, x, len(compare_string))
        print(r)
        if r == 1:
            answer.append(True)
        else:
            answer.append(False)
    return answer

a = ["abab","bbaa","bababa","bbbabababbbaa","bbbbabbbb"]
print(solution(a))