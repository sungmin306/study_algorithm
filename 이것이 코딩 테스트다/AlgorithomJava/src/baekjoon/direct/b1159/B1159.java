package baekjoon.direct.b1159;

import java.io.*;
public class B1159 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            int a = name.charAt(0);
            alpha[a-97]++;
        }
        boolean checkValue = false;
        for(int i = 0; i < alpha.length; i++) {
            if (alpha[i] >= 5) {
                checkValue = true;
                char c = (char) (97 + i);
                System.out.print(c);
            }
        }
        if(!checkValue) {
            System.out.println("PREDAJA");
        }
    }
}


