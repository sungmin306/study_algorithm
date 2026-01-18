

import java.util.*;
import java.io.*;

public class Main {

    public static int[][] damage = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-3,-9},{-1,-9,-3}};
    static int[][][] dp;
    static int min;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] scv = new int[3];
        for(int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[61][61][61];
        min = Integer.MAX_VALUE;
        dfs(scv,0);
        System.out.println(min);
    }
    public static void dfs(int[] scv, int cnt) {
        int scv1 = scv[0];
        int scv2 = scv[1];
        int scv3 = scv[2];

        if(min <= cnt){
            return;
        }

        if(dp[scv1][scv2][scv3] != 0 && dp[scv1][scv2][scv3] <= cnt) {
            return;
        }

        dp[scv1][scv2][scv3] = cnt;
        if(scv1 == 0 && scv2 == 0 && scv3 ==0) {
            min = Math.min(cnt,min);
            return;
        }

        for(int i = 0; i < 6; i++) {
            int newScv1 = Math.max(scv1 + damage[i][0], 0);
            int newScv2 = Math.max(scv2 + damage[i][1], 0);
            int newScv3 = Math.max(scv3 + damage[i][2], 0);
            dfs(new int[] {newScv1,newScv2,newScv3},cnt+1);

        }

    }
}
