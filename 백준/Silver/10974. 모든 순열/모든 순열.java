import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb;

    public static void dfs(int d) {
        if(d == N) {
            for(int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            arr[d] = i;
            visit[i] = true;
            dfs(d + 1);
            visit[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        arr = new int[N];
        visit = new boolean[N + 1];
        dfs(0);
        System.out.println(sb);

    }
}
