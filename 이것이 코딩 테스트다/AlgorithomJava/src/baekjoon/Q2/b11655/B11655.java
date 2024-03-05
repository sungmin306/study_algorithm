package baekjoon.Q2.b11655;

import java.util.*;
import java.io.*;
public class B11655 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        // 65 ~ 90 대문자
        // 97 ~ 122 소문자
        for(int i = 0; i < arr.length; i++) {
            if(!Character.isLetter(arr[i])) {
                sb.append(arr[i]);
                continue;
            }
            if(Character.isUpperCase(arr[i])) {
                int a = (int)arr[i] + 13;
                if(a > 90) {
                    sb.append((char)(64 + (a - 90)));
                }
                else{
                    sb.append((char)a);
                }
            }
            else {
                int a = (int)arr[i] + 13;
                if(a > 122) {
                    sb.append((char)(96 + (a - 122)));
                }
                else{
                    sb.append((char)a);
                }
            }
        }
        System.out.println(sb);
    }
}
