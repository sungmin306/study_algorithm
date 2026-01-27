import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, ans;
    public static int[] arr;
    public static int[] numbers;
    public static boolean[] visit;



    public static void dfs(int d) {
        if(d == N) {
            int sum = 0;
            for(int i = 0; i < N-1; i++) {
                sum += Math.abs(numbers[i] - numbers[i + 1]);
            }
            ans = Math.max(ans, sum);
        }

        for(int i = 0; i < N; i++) {
            if(!visit[i]) {
                numbers[d] = arr[i];
                visit[i] = true;
                dfs(d + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        numbers = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;
        dfs(0);
        System.out.println(ans);
    }
}
