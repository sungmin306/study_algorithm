import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N,ans;
    public static int[][] W;
    public static boolean[] visit;

    public static void dfs(int depth, int start, int prev, int sum) {
        if(sum >= ans) return;

        if(depth == N) {
            if(W[prev][start] == 0) return;
            ans = Math.min(ans, sum + W[prev][start]);
            return;
        }

        for(int next = 0; next < N; next++) {
            if(visit[next]) continue;
            if(W[prev][next] == 0) continue;
            visit[next] = true;
            dfs(depth + 1, start, next, sum + W[prev][next]);
            visit[next] = false;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visit = new boolean[N];
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[0] = true;
        dfs(1,0,0,0);
        System.out.println(ans);
    }
}
