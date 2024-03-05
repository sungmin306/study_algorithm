package baekjoon.direct.b2178;

import java.util.*;
import java.io.*;

public class B2178 {

    public static int[][] miro;
    public static boolean[][] visited;
    public static int n;
    public static int m;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;
        for(int i = 0; i < n; i++) { // 미로 입력
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                miro[i][j] = s.charAt(j) - '0'; // 숫자로 변환
            }
        }
        bfs(0,0);
        System.out.println(miro[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                if (!visited[nextX][nextY] && miro[nextX][nextY] != 0){
                    q.add(new int[] {nextX, nextY});
                    miro[nextX][nextY] = miro[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
