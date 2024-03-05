package baekjoon.Q1.b1213;

import java.io.*;
import java.util.*;


public class B1213 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int[] alpha = new int[26];
        for(int i = 0; i < charArray.length; i++) {
            alpha[((int)charArray[i] - 65)]++;
        }
        System.out.println(check(charArray,alpha));
    }
    public static String check(char[] charArray,int[] alpha) {
        int cnt = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0){
                cnt++;
                num = i; // 홀수가 하나인것만을 이용
            }
            if(cnt > 1) {
                return "I'm Sorry Hansoo";
            }
        }
        for(int i = 0; i < alpha.length; i++) {
            for(int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i+65));
            }
        }
        String result = sb.toString();
        if(cnt == 1) {
            result +=(char)(num + 65);
        }
        result += sb.reverse().toString();
        return result;
    }

}
