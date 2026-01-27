import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] arr;
    public static int[] numbers;
    public static StringBuilder sb;

    public static void dfs(int idx, int depth) {
        if(depth == 6) {
            for(int i = 0; i < 6; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx + 1; i < N; i++) {
            numbers[depth] = arr[i];
            dfs(i,depth + 1);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            numbers = new int[6];
            if(N == 0) break;
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            for(int i = 0; i < N; i++) {
                numbers[0] = arr[i];
                dfs(i,1);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
