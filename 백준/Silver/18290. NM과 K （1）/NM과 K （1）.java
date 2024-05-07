
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N,M,K;
    public static int[][] arr;
    public static boolean[][] visited;
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static int max = Integer.MIN_VALUE;

    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
       return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean check(int x, int y) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx,ny) && visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int d, int x, int y, int sum) {
        if(d == K) {
            max = Math.max(sum, max);
            return;
        }

        for(int i = x; i < N; i++) {
            for(int j = y; j < M; j++) {
                if(visited[i][j]) continue;
                if(check(i,j)) {
                    visited[i][j] = true;
                    dfs(d + 1, i, j, sum + arr[i][j]);
                    visited[i][j] = false;
                }
            }
            y = 0;
        }

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,0);
        System.out.println(max);
    }
}
