import java.util.*;
import java.io.*;

public class Main {
    public static int T;
    public static int n,m,k;
    public static int[][] map;
    public static boolean[][] visited;
    public static StringBuilder sb;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};



    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x]= 1;
            }
            bfs();
        }
        System.out.println(sb);
    }
    public static void bfs() {
        int cnt = 0;
        for(int x = 0; x < map.length; x++) {
            for(int y = 0; y < map[0].length; y++) {
                if (visited[x][y] || map[x][y] == 0)
                    continue;
                Queue<int []> queue = new LinkedList<>();
                queue.add(new int[] {x,y});

                while(!queue.isEmpty()) {
                    int[] now = queue.poll();
                    int nowX = now[0];
                    int nowY = now[1];

                    for(int i = 0; i < 4; i++) {
                        int newX = nowX + dx[i];
                        int newY = nowY + dy[i];
                        if (newX < 0 || newY < 0 || newX >= n || newY >= m)
                            continue;
                        if (visited[newX][newY] || map[newX][newY] == 0)
                            continue;
                        queue.add(new int[] {newX,newY});
                        visited[newX][newY] = true;
                    }
                }
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
    }
}
