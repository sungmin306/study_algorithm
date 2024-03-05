package baekjoon.direct.b1436;

import java.io.*;

public class B1436 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int value = 666;
        for(int i = 0; i < arr.length; i++) {
            while(true) {
                int cnt = 0;
                int m = value;
                while(m !=0) {
                    int d = m % 10;
                    if(d ==6) cnt++;
                    else cnt=0;
                    if(cnt == 3) break;
                    m = m / 10;
                }
                if(cnt >= 3) {
                    arr[i] = value;
                    value++;
                    break;
                }
                value++;
            }
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(arr[n-1]);
    }
}
