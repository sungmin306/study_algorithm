import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int ans = 0;
    public static int[][] map;
    public static boolean[][] visit;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static void dfs(int x, int y, int d, int sum) {
        if(d == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, d + 1, sum + map[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

    public static void checkT(int x, int y) {
        int count = 0;
        int sum = map[x][y];
        int minValue = 1000;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny)) {
                count++;
                sum += map[nx][ny];
                minValue = Math.min(minValue, map[nx][ny]);
            }
        }
        if(count == 3) {
            ans = Math.max(sum, ans);
        }
        else if(count == 4) {
            sum = sum - minValue;
            ans = Math.max(sum, ans);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
                checkT(i, j);
            }
        }
        System.out.println(ans);
    }
}

