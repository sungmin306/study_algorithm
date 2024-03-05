package baekjoon.direct.b3474;

import java.io.*;

public class B3474 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int num5 = 0;
            int cnt = 0;

            for(int j = 5; j <= n; j*= 5) {
                cnt += n / j;
            }
            System.out.println(cnt);
        }
    }

}
