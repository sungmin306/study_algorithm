package baekjoon.direct.b10808;

import java.io.*;

public class B10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[26];

        String inputString = br.readLine();
        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            int a = c;
            alpha[a - 97]++;
        }
        for(int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}
