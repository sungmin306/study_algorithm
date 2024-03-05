package baekjoon.direct.b1940;

import java.util.*;
import java.io.*;

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
        int result = 0;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            if(arr[i] + arr[j] < m) {
                i++;
            }
            else if(arr[i] + arr[j] > m) {
                j--;
            }
            else {
                result++;
                i++;
                j--;
            }
        }
        System.out.println(result);
    }
}
