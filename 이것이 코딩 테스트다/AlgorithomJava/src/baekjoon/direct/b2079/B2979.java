package baekjoon.direct.b2079;

import java.io.*;
import java.util.*;

public class B2979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[3];
        int[] result = new int[100];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            for (int j = start; j < end; j++) {
                result[j]++;
            }
        }
        //System.out.println(Arrays.toString(result));

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) continue;
            else if (result[i] == 1) {
                    sum += result[i] * inputArr[0];
            } else if (result[i] == 2) {
                sum += result[i] * inputArr[1];
            } else if (result[i] == 3) {
                sum += result[i] * inputArr[2];
            }
        }
        System.out.println(sum);
    }
}
