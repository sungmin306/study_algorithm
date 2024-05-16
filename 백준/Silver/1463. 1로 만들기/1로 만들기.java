

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int X;
    public static int[] dp;

    public static int func(int n) {

        if(dp[n] == -1) {
            if(n % 6 == 0) {
                dp[n] = Math.min(func(n -1), Math.min(func(n / 3), func(n /2))) + 1;
            }
            else if(n % 3 == 0) {
                dp[n] = Math.min(func(n /3), func(n - 1)) + 1;
            }
            else if(n % 2 ==0) {
                dp[n] = Math.min(func(n /2), func(n -1)) + 1;
            }
            else {
                dp[n] = func(n -1) + 1;
            }
        }
        return dp[n];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        dp = new int[X + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(func(X));
    }
}
