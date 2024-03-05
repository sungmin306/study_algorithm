package baekjoon.Q2.b1940;

import java.util.*;
import java.io.*;

public class B1940 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int start = 0;
        int end = n-1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        while(start < end) {
            if(arr[start] + arr[end] == m) {
                result++;
                start++;
            }
            else if(arr[start] + arr[end] < m) {
                start++;
            }
            else if(arr[start] + arr[end] > m) {
                end--;
            }
        }
        System.out.println(result);
    }
}


/*
1 2 3 4 5 6
 */