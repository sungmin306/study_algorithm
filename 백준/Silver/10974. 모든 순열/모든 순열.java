import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int d) {
        if(d == N) {
            for(int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[d] = i;
                dfs(d + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        arr = new int[N];

        dfs(0);
        System.out.println(sb);
    }
}
