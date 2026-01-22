import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr;
    public static int N;
    public static int ans;

    public static void dfs(int d, int sum) {
        if(d > N) {
            ans = Math.max(ans, sum);
            return;
        }
        if(d + arr[d][0] <= N + 1) {
            dfs(d + arr[d][0],sum + arr[d][1]);
        }
        dfs(d + 1, sum);
    }

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
        dfs(1,0);

        System.out.println(ans);
    }
}
