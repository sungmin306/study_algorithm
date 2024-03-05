package baekjoon.direct.b2559;

import java.util.*;
import java.io.*;
public class B2559 {
//    public static void main(String[] args)throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for(int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st2.nextToken());
//        }
//        int result = -1000000;
//        for(int i = 0; i < n-(k-1); i++) {
//            int comValue = 0;
//            for(int j = 0; j < k; j++) {
//                comValue += arr[i+j];
//            }
//            result = Math.max(result, comValue);
//        }
//        System.out.println(result);
//    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] DP = new int[n+1];
        for(int i = 1; i < n+1; i++) {  // n
            DP[i] = DP[i-1] + Integer.parseInt(st.nextToken());
        }
        int result = -100000;
        for(int i = k;  i < n+1; i++) { // n
            int sum = DP[i] - DP[i-k];
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}  // 2n -> O(n)
