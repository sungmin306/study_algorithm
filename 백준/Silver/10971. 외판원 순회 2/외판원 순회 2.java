import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, ans;
    public static int[] numbers;
    public static int[][] W;
    public static boolean[] visit;

    public static void dfs(int d, int start, int prev, int sum) {
        if(sum >= ans) return; // 백트래킹

        if(d == N) {
            if(W[prev][start] == 0) return; // 돌아오는 길 없음
            ans = Math.min(ans,sum + W[prev][start]);
            return;
        }

        for(int next = 0; next < N; next++) { {
            if(visit[next]) continue;
            if(W[prev][next] == 0) continue;

            visit[next] = true;
            dfs(d + 1, start, next, sum + W[prev][next]);
            visit[next] = false;
        }

        }


    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        numbers = new int[N];
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
