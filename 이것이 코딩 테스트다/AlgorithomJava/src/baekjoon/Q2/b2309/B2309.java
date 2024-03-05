package baekjoon.Q2.b2309;

import java.util.*;
import java.io.*;

public class B2309 {
    public static int sum;
    public static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        sum = 0;
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        check();
        Arrays.sort(arr);
        for(int i = 2; i < 9; i++) System.out.println(arr[i]);
    }
    public static void check() {
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    return;
                }
            }
        }
    }
}
