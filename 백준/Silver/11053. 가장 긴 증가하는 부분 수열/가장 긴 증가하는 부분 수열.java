import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] A;
    public static Integer[] dp;

    public static int lis(int n) {
        if(dp[n] == null) {
            dp[n] = 1;

            for(int i = n -1; i >= 0; i--) {
                if(A[i] < A[n])
                    dp[n] = Math.max(dp[n], lis(i) + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            lis(i);
        }

        int max = dp[0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
