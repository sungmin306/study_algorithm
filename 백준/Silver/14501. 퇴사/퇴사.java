import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, ans;
    public static int[][] arr;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        ans = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];

        for(int i = 1; i <= N; i++) {
            dp[i + 1] = Math.max(dp[i+1],dp[i]);

            int t = arr[i][0];
            int p = arr[i][1];

            if(i + t <= N + 1) {
                dp[i + t] = Math.max(dp[i+t], dp[i] + p);
            }
        }
        System.out.println(dp[N+1]);
    }
}
