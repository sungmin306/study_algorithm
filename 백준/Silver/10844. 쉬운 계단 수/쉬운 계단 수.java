

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long result = 0;
        long[][] dp = new long[n+ 1][10];

        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                }
                else if(j == 9) {
                    dp[i][9] = dp[i - 1][8] % 1000000000;
                }
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        for(int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        System.out.println(result % 1000000000);
    }
}
