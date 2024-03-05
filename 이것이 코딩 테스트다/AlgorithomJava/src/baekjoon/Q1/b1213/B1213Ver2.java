package baekjoon.Q1.b1213;

import java.util.*;
import java.io.*;

public class B1213Ver2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int[] alpha = new int[26];
        for(int i = 0; i < s.length; i++) {
            alpha[(int)(s[i]) - (int)'A']++;
        }
        check(alpha, s);

    }
    public static void check(int[] alpha, char[] c) {
        int cnt = 0;
        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i] % 2 != 0) cnt++;
        }
        if(cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder front = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for(int i = 0; i < alpha.length; i++) {
            while(alpha[i] >= 2) {
                front.append((char)((int)'A' + i));
                alpha[i]-=2;
            }
        }
        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i] == 1) {
                mid.append((char)((int)'A' + i));
                break;
            }
        }
        String result = front.toString() + mid.toString();
        String back = front.reverse().toString();
        result += back;
        System.out.println(result);
    }
}
