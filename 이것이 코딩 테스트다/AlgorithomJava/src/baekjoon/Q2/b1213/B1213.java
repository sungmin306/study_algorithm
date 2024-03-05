package baekjoon.Q2.b1213;

import java.util.*;
import java.io.*;

public class B1213 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder front = new StringBuilder();

        String s = br.readLine();
        int[] alphaCnt = new int[26];

        for(int i = 0; i < s.length(); i++) {
            alphaCnt[s.charAt(i) - (int)'A']++;
        }
        int cnt = 0; // 홀수 세는 변수
        boolean check = true;
        for(int i = 0; i < alphaCnt.length; i++) {
            if(alphaCnt[i] % 2 != 0) cnt ++;
            if(cnt > 1) {
                System.out.println("I'm Sorry Hansoo");
                check = false;
                break;
            }
        }
        String result = new String();
        //System.out.println(Arrays.toString(alphaCnt));
        if(check) {
            for(int i = 0; i < alphaCnt.length; i++) {
                while(true) {
                    if(alphaCnt[i] <= 1) break;
                    front.append((char) (i + 65));
                    alphaCnt[i] = alphaCnt[i] -2;
                }
            }
            result += front.toString();

            for(int i = 0; i < alphaCnt.length; i++) {
                if(alphaCnt[i] == 1) {
                    result += (char) (i + 65);
                }
            }
            result += front.reverse().toString();

        }

        System.out.println(result);

    }
}
