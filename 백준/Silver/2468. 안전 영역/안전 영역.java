
import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) { // 입력
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        int result = 0;
        for(int h = 0; h < max; h++) {
            visited = new boolean[n][n];
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j]- h > 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i,j,h);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);

    }
    public static void dfs(int x, int y, int h) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0|| nx >= n || ny >= n) continue;
            if(!visited[nx][ny] && map[nx][ny] - h > 0) {
                visited[nx][ny] = true;
                dfs(nx,ny,h);
            }
        }

    }
}
