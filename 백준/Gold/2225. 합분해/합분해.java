import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N,K;
    public static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K+1][N+1];

        for(int i = 1; i <=K; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD;
            }
        }
        System.out.println(dp[K][N]);

    }
}
