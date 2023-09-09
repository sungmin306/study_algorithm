package chapter4;

import java.util.*;

public class Num3 {
    public static int m, n , r , c ,d;
    public static int[][] visits = new int[50][50];
    public static int[][] arr = new int[50][50];
    public static int dc[] = {-1,0,1,0};
    public static int dr[] = {0,1,0,-1};

    public static void turnLeft() {
        d -= 1;
        if (d == -1) d = 3;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         n = sc.nextInt();
         m = sc.nextInt();

         r = sc.nextInt();
         c = sc.nextInt();
         d = sc.nextInt();
         visits[c][r] = 1;

         for(int i = 0; i<n; i++) {
             for(int j = 0; j < m; j ++) {
                 arr[i][j] = sc.nextInt();
             }
         }

         int cnt = 1;
         int turnTime = 0;
         while(true) {
             //System.out.println("반복문돕니다.");
             turnLeft(); // 왼쪽으로 회전
             int nr = r + dr[d];
             int nc = c + dc[d];
             if (visits[nc][nr] == 0 && arr[nc][nr]== 0) {
                 visits[nc][nr] = 1;
                 r = nr;
                 c = nc;
                 cnt += 1;
                 turnTime = 0;
                 continue;
             }
             else turnTime += 1;
             if(turnTime == 4) {
                 nr = r - dr[d];
                 nc = c - dr[d];

                 if(arr[nc][nr] == 0) {
                     r = nr;
                     c = nc;
                 }
                 else break;
                 turnTime = 0;
             }
         }
        System.out.println(cnt);
    }
}


