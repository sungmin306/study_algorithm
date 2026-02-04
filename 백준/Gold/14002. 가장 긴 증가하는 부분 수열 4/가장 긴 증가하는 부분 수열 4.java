import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] A;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        int ans = 0;

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        sb.append(ans).append("\n");

        Stack<Integer> stack = new Stack<>();

        for(int i = N-1; i >= 0; i--) {
            if(ans == dp[i]) {
                stack.push(A[i]);
                ans--;
            }
        }

        while(!stack.empty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);

    }
}
