package baekjoon.direct.b10988;

import java.io.*;

public class B10988 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        System.out.println(check(inputString));
    }
    public static int check(String s) {
            for(int i = 0; i < s.length()/2; i++) {
                if (s.charAt(i) != s.charAt(s.length()-1-i))
                    return 0;
            }
            return 1;
    }
}
