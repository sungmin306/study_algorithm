package baekjoon.Q1.b2559;

import java.util.*;
import java.io.*;

public class B2559 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            dp[i] = dp[i-1] + arr[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i = k; i < n+1; i++) {
            int sum = dp[i] - dp[i-k];
            if(max < sum) max = sum;
        }
        System.out.println(max);
    }
}
