package baekjoon.Q1.b14052;

import java.util.*;
import java.io.*;


public class B14052 {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int result = 0;
    public static boolean[][] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int cnt) {

        if(cnt == 3) {
            bfs();
        }
        else {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        dfs(cnt+1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) { // 바이러스 시작 위치를 다 queue에 넣기
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2)
                queue.add(new int[] {i,j});
            }
        }

        visited = new boolean[n][m];

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i  = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX,nextY});
                }
            }
        }
        checkSafeArea();
    }

    public static void checkSafeArea() {
        int safeAreaCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 0) {
                    safeAreaCount++;
                }
            }
        }
        result = Math.max(safeAreaCount, result);
    }



}
