package baekjoon.Q1.b1629;

import java.util.*;
import java.io.*;

public class B1629 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c= Integer.parseInt(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    public static long pow(int a, int b, int c) {
        if(b == 1) {
            return a % c;
        }
        long temp = pow(a,b/2,c);
        if (b % 2 == 1) return (temp * temp % c) * a % c;
        return temp * temp % c;

    }
}
