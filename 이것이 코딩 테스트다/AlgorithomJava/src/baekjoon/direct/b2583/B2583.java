package baekjoon.direct.b2583;

import java.util.*;
import java.io.*;


public class B2583 {
    public static int m,n,k;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int cnt;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        int region = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(!visit[i][j] && map[i][j] != 1) {
                    cnt = 1;
                    dfs(i,j);
                    //bfs(i,j);
                    region++;
                    arrayList.add(cnt);
                }
            }
        }
        System.out.println(region);
        Collections.sort(arrayList);
        for(int x : arrayList) {
            System.out.print(x + " ");
        }


    }
    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                if(!visit[nextX][nextY] && map[nextX][nextY] != 1) {
                    cnt++;
                    dfs(nextX,nextY);
                }
            }
        }
    }

//    public static void bfs(int x, int y) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] {x,y});
//
//        while(!queue.isEmpty()) {
//            int[] now = queue.poll();
//            int nowX = now[0];
//            int nowY = now[1];
//            for(int i = 0; i < 4; i++) {
//                int nextX = nowX + dx[i];
//                int nextY = nowY + dy[i];
//                if(nextX >= 0 && nextY >= 0 && nextX < n || nextY < m) {
//                    if(!visit[nextX][nextY] && map[nextX][nextY] != 1) {
//                        queue.add(new int[] {nextX,nextY});
//                        visit[nextX][nextY] = true;
//                        cnt++;
//                    }
//                }
//            }
//        }
//    }
}
