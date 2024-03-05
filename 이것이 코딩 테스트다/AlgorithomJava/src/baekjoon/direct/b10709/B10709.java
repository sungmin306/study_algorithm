package baekjoon.direct.b10709;

import java.io.*;
import java.util.*;

public class B10709 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] sky = new int[h][w];
        boolean[][] checkCloud = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j] != 'c') {
                    continue;
                }
                checkCloud[i][j] = true;
                int cnt = 1;
                for(int k = j+1; k < arr.length; k++) {
                    if(arr[k] == '.') {
                        sky[i][k] = cnt;

                    }
                    checkCloud[i][k] = true;
                    cnt++;
                }
            }
        }
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(!checkCloud[i][j] && sky[i][j] == 0) {
                    sky[i][j] = -1;
                }
            }
        }
        //System.out.println(Arrays.deepToString(checkCloud));
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                System.out.print(sky[i][j] + " ");
            }
            System.out.println();
        }

    }
}
