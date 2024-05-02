
import java.util.*;
import java.io.*;
public class Main {
    public static int T;
    public static int N, M, K;

    public static int X,Y;

    public static int result;

    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
        return 0<= x && x < N && 0 <= y && y < M;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i  < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx,ny)) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx,ny);
                }
            }


        }
    }

    public static void main(String[] args)throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            result = 0;
            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);


    }


}
