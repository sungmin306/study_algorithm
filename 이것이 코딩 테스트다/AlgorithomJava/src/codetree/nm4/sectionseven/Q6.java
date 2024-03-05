package codetree.nm4.sectionseven;


import java.util.*;
import java.io.*;

public class Q6 {
    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tile = new int[20];
        int point = 10;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            for(int j = 0; j < x; j++) {
                if (c.equals("R")) {
                    tile[point] = 1;
                    if(j!= x-1) {
                        point++;
                    }
                }
                if (c.equals("L")) {
                    tile[point] = -1;
                    if(j!= x-1) {
                        point--;
                    }
                }
            }
            System.out.println(Arrays.toString(tile));
        }
        int w = 0;
        int b = 0;
        for(int i = 0; i < tile.length; i++) {
            if(tile[i] == -1) {
                w++;
            }
            else if(tile[i] == 1) {
                b++;
            }
        }
        System.out.println(w + " " + b);
    }
}