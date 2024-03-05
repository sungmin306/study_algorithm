package baekjoon.direct.b1992;

import java.io.*;

public class B1992 {

    public static int[][] video;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        video = new int[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            for(int j = 0; j < n; j++) {
                video[i][j] = s.charAt(j) - '0';
            }
        }
        QuadTree(0,0,n);
        System.out.println(sb);
    }
    public static void QuadTree(int x, int y, int size) {

        // 압축이 가능할 경우 하나의 색상으로 압축해준다.
        if(isPossible(x,y,size)) {
            sb.append(video[x][y]);
            return;
        }
        int newSize = size / 2;

        sb.append('(');

        QuadTree(x,y,newSize);
        QuadTree(x,y + newSize ,newSize);
        QuadTree(x + newSize,y ,newSize);
        QuadTree(x + newSize,y + newSize ,newSize);

        sb.append(')');
    }
    public static boolean isPossible(int x, int y, int size) {
        int value = video[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != video[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
