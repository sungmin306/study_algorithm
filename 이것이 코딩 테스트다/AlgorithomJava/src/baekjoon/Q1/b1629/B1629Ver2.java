package baekjoon.Q1.b1629;

import java.util.*;
import java.io.*;
public class B1629Ver2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(calc(a, b, c));
    }
    public static long calc(int a, int b, int c) {
        if(b == 1) {
            return a % c;
        }
        long temp = calc(a,b/2,c);
        System.out.println(temp);
        if (b % 2 == 1) return (temp * temp % c)* a % c;
        System.out.println(temp * temp % c);
        return temp *temp % c;
    }
}
