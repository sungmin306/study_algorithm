

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static Queue<int[]> queue = new LinkedList<>();
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
    public static void bfs() {
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(inRange(nextX,nextY) && map[nextX][nextY] == 0) {
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static int result() {
        int maxDay = -1;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) return -1;
                if(map[i][j] > maxDay) maxDay = map[i][j];
            }
        }
        if(maxDay == 1) return 0;
        return maxDay - 1;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 6
        M = Integer.parseInt(st.nextToken()); // 4
        map = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.add(new int[] {i,j});
                }
            }
        }
        bfs();
        //System.out.println(Arrays.deepToString(map));
        System.out.println(result());
    }
}
