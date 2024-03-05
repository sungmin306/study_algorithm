package baekjoon.Q1.b2718;

import java.util.*;
import java.io.*;

public class B2718BFS {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n,m;
    public static int[][] miro;
    public static boolean[][] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        check = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                miro[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(miro[n-1][m-1]);
    }
    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a,b});

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue; // 배열 밖으로 벗어나는 것은 무시
                if(miro[nextX][nextY] != 0 && !check[nextX][nextY]){
                    queue.add(new int[] {nextX,nextY});
                    check[nextX][nextY] = true;
                    miro[nextX][nextY] = miro[nowX][nowY] + 1;
                }
            }
        }
    }


    // 그래프 탐색
    // DFS BFS
    // DFS(모든 구간 탐색) -> BFS
    // BFS(최단 거리)

}
