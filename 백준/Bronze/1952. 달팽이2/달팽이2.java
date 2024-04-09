
import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int x = 0, y = 0;
    public static int nx, ny;
    public static int[][] map;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static int dirNum = 0;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int cnt = 0;
        map[x][y] = 1;
        for (int i = 2; i <= n * m; i++) {
            nx = x + dx[dirNum];
            ny = y + dy[dirNum];

            if(!inRange(nx,ny) || map[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4;
                cnt++;
            }

            x = x + dx[dirNum];
            y = y + dy[dirNum];

            map[x][y] = 1;
        }
        System.out.println(cnt);
    }
}
