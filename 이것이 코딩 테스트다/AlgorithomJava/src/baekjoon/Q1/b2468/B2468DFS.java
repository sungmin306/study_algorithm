package baekjoon.Q1.b2468;

import java.util.*;
import java.io.*;

public class B2468DFS {
    public static int n;
    public static int[][] region;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int max = 0;
        int result = 0;
        region = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                if (max < region[i][j]) max = region[i][j];
            }
        }
        for(int h = 0; h < max + 1; h++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && region[i][j] > h) {
                        cnt+= dfs(i,j,h);
                    }
                }
            }
            result = Math.max(result,cnt);
        }
        System.out.println(result);
    }
    public static int dfs(int a, int b, int h) {
        visited[a][b] = true;
        for(int i = 0; i < 4; i++) {
            int nextX = a + dx[i];
            int nextY = b + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if(!visited[nextX][nextY] && region[nextX][nextY] > h) {
                dfs(nextX,nextY,h);
            }
        }
        return 1;
    }
}
