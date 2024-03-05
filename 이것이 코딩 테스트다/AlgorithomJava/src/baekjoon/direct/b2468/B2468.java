package baekjoon.direct.b2468;

import java.util.*;
import java.io.*;

public class B2468 {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) { // 지역 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for(int h = 0; h <= findMax(map); h++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && map[i][j] > h){
                        dfs(i,j,h);
                        cnt++;
                    }
                }
            }
            result = Math.max(result,cnt);
        }
        System.out.println(result);
    }
    public static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if(visited[nextX][nextY] || map[nextX][nextY] <= h) continue;
            dfs(nextX,nextY,h);

        }
    }
    public static int findMax(int[][] map) {
        int max = 0;
        for(int[] arr : map) {
            for(int x : arr) {
                if(max < x) max = x;
            }
        }
        return max;
    }
}
