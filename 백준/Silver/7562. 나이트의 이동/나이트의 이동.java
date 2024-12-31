
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int T, l,sx,sy,fx,fy;
    public static boolean[][] map;
    public static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    public static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < l && 0 <= y && y < l;
    }

    public static int bfs(int sx, int sy, int fx, int fy) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int[] tmp = new int[] {sx,sy,0};
        map[sx][sy] = true;
        queue.add(tmp);
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];
            if(nowX == fx && nowY ==fy) {
                return dist;
            }

            for(int i = 0; i < 8; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if(inRange(newX,newY) && !map[newX][newY]) {
                    map[newX][newY] = true;
                    queue.add(new int[]{newX,newY,dist+1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            map = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            sb.append(bfs(sx,sy,fx,fy)).append("\n");
        }
        System.out.println(sb);
    }
}
