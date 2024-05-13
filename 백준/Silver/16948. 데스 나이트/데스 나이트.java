
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int r1,r2,c1,c2;

    public static int[] dx = {-2,-2,0,0,2,2};
    public static int[] dy = {-1,1,-2,2,-1,1};
    public static int[][] map;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            if(nowX == r2 && nowY == c2) break;

            for(int i = 0; i < 6; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(inRange(nextX,nextY) && map[nextX][nextY] == -1) {
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }
        return map[r2][c2];
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) { // 체스판 -1 초기화
            for(int j = 0; j < N; j++) {
                map[i][j] = -1;
            }
        }
        map[r1][c1] = 0;
        System.out.println(bfs(r1,c1));
    }
}
