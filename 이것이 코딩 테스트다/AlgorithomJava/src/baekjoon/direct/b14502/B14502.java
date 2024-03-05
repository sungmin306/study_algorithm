package baekjoon.direct.b14502;

import java.util.*;
import java.io.*;
public class B14502 {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static int safeZoneSize = 0;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i = 0; i < n; i++) { // 입력
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        dfs(0);
        System.out.println(safeZoneSize);
    }
    public static void dfs(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                   map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) {
                    queue.add(new int[] {i,j});
                }
            }
        }
        int[][] copyMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >=n || nextY >= m) continue;
                if(copyMap[nextX][nextY] == 0) {
                    queue.add(new int[] {nextX, nextY});
                    copyMap[nextX][nextY] = 2;
                }
            }
        }
        safeZone(copyMap);
    }

    public static void safeZone(int[][] copyMap) {
        int size = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0) size++;
            }
        }
        safeZoneSize = Math.max(safeZoneSize, size);
    }
}
