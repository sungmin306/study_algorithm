package baekjoon.direct.b1213;

import java.util.*;
import java.io.*;

public class B1213 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] arr = new int[26];
        for(int i =0; i < s.length(); i++) {
            int index = s.charAt(i)- 'A';
            arr[index]++;
        }
        int odd = 0;
        int num = 0;
        for(int i =0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                num = i;
            }
            if( odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        for(int i = 0; i < arr.length;i++) {
            for(int j = 0; j < arr[i] / 2; j++) {
                sb.append((char)(i+'A'));
            }
        }
        String result = sb.toString();
        if (odd == 1) {
            result += (char) (num + 'A');
        }
        result += sb.reverse().toString();
        System.out.println(result);



    }
}
