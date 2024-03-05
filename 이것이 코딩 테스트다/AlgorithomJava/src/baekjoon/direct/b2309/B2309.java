package baekjoon.direct.b2309;

import java.util.*;
import java.io.*;

public class B2309 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++) { // 입력 및 입력한 값 합산
            inputArr[i] = Integer.parseInt(br.readLine());
            sum += inputArr[i];
        }
        for(int i = 0; i < 8; i++) { // 9명중에서 2명 뺀 사람의 합이 100일경우 찾기
            for(int j = i+1; j < 9; j++) {
                if (sum - inputArr[i] - inputArr[j] == 100) {
                    inputArr[i] = 0;
                    inputArr[j] = 0;
                    Arrays.sort(inputArr);
                    for(int k = 2; k < 9; k++) {
                        System.out.println(inputArr[k]);
                    }
                    return;
                }
            }
        }
    }
}
