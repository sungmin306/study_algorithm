import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N,M;
    public static int ans = 0;
    public static int[][] map;
    public static boolean[][] visit;

    public static void dfs(int depth, int num, int sum) {
        if(depth == N * M) {
            ans = Math.max(ans, sum);
            return;
        }
        int r = depth / M;
        int c = depth % M;

        if(visit[r][c]) {
            dfs(depth + 1, num, sum);
            return;
        }

        visit[r][c] = true;

        num = num * 10 + map[r][c];
        dfs(depth + 1, 0, sum + num); // 하나만 확정하고 다음 조각으로 넘김

        int temp = num;
        int i;

        for(i = r + 1; i < N; i++) { // 세로로 내려가서 방문 확인
            if(visit[i][c]) break;

            visit[i][c] = true;
            temp = temp * 10 + map[i][c];
            dfs(depth + 1, 0, sum + temp);
        }

        for(int j = r + 1; j < i; j++) visit[j][c] = false;

        temp = num;
        for(i = c + 1; i < M; i++) { // 가로로 가면서 방문 확인
            if(visit[r][i]) break;

            visit[r][i] = true;
            temp = temp * 10 + map[r][i];
            dfs(depth + (i - c) + 1, 0, sum + temp);
        }

        for(int j = c + 1; j < i; j++) {
            visit[r][j] = false;
        }

        visit[r][c] = false;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
}
