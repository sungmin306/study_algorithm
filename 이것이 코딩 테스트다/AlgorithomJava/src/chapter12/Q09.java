package chapter12;
import java.util.*;

public class Q09 {
    public static int solution(String s) {
        int answer = s.length();

        for (int step = 1; step < (s.length() / 2) + 1; step++) {
            String compressed = "";
            String prev = s.substring(0,step);
            int cnt = 1;

            for(int j = step; j < s.length(); j += step) {
                String sub = "";
                for (int k = j; k < j + step; k++) { // 다음 글자를 길이까지 추가해 sub에 대입
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1; // 같으면 cnt 1 증가
                else{
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub;
                    cnt = 1;
                }
            }
            compressed += (cnt >= 2) ? cnt + prev : prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }


}
