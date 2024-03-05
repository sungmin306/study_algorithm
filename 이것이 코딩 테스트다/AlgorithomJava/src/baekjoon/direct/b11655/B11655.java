package baekjoon.direct.b11655;

import java.io.*;

public class B11655 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] rot13 = br.readLine().toCharArray(); // toCharArray -> 문자열 배열로 변환
        for(int i = 0; i < rot13.length; i++) {
            if(!Character.isLetter(rot13[i])) {
                sb.append(rot13[i]);
                continue;
            }
            int n = (int) rot13[i] + 13;

            if (Character.isUpperCase(rot13[i]) && n > 90) {
                n -= 26;
            }

            if (Character.isLowerCase(rot13[i]) && n > 122) {
                n -= 26;
            }
            sb.append((char)n);
        }
        System.out.println(sb);
    }
}
