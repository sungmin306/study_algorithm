import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static boolean[] visit;
    public static int[][] map;
    public static int result = Integer.MAX_VALUE;

    public static void dfs(int d, int sum, int s, int e) {
        if(sum >= result) return;
        if(d == N) {
            if(map[e][s] == 0) return;
            sum = sum + map[e][s];
            result = Math.min(result, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            if(map[e][i] == 0) continue;
            visit[i] = true;
            dfs(d + 1,sum + map[e][i] ,s, i);
            visit[i] = false;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(1, 0, i, i);
            visit[i] = false;
        }
        System.out.println(result);
    }
}
