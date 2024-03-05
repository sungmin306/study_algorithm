package baekjoon.direct.b2828;

import java.util.*;
import java.io.*;

public class B2828 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        int startPoint = 1;
        int endPoint = m;
        int cnt = 0;
        for(int i = 0; i < t; i++) {
            int p = Integer.parseInt(br.readLine());
            if (startPoint > p) {
                int num = startPoint - p;
                startPoint = startPoint - num;
                endPoint = endPoint - num;
                cnt += num;
            }
            if (endPoint < p) {
                int num = p - endPoint;
                startPoint = startPoint + num;
                endPoint = endPoint + num;
                cnt += num;
            }
        }
        System.out.println(cnt);
    }
}
