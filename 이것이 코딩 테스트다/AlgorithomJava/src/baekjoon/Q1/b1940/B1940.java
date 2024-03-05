package baekjoon.Q1.b1940;

import java.io.*;
import java.util.*;

public class B1940 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        int result = 0;
        while(i < j) {
            if (arr[i] + arr[j] == m) {
                result++;
                i++;
            }
            else if (arr[i] + arr[j] > m) {
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println(result);
    }
}
