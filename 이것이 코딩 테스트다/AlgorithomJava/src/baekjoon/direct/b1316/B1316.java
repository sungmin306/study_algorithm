package baekjoon.direct.b1316;

import java.io.*;


public class B1316 {

    // dx , dy 테크니컬

    public static int[] dx = {-1,1,0,0};// 상하
    public static int[] dy = {0,0,-1,1}; // 좌우

    public static void main(String[] args)throws IOException {//1
        int[][] arr = new int[3][3]; // 이차원 배열
        int start = 1;

//        System.out.println(arr[start-1][start]);
//        System.out.println(arr[start+1][start]);
//        System.out.println(arr[start][start-1]);
//        System.out.println(arr[start][start+1]);

        for(int i = 0; i < 4; i++) {
            System.out.println(arr[start+dx[i]][start+dy[i]]);
        }
    }

}
