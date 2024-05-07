
import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] miro;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                miro[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
    }
//    public static void dfs(int x, int y, int cnt) {
//
//        if(x == n -1 && y == m -1) {
//            System.out.println(cnt);
//            return;
//        }
//
//        for(int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
//            if(!visited[nx][ny] && miro[nx][ny] == 1) {
//                visited[nx][ny] = true;
//                dfs(nx, ny, cnt + 1);
//            }
//        }
//    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        int distance = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny] && miro[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                    miro[nx][ny] = miro[nowX][nowY] + 1;
                }
            }
        }
        System.out.println(miro[n-1][m-1]);
    }

    public static class Node {
        public int x;
        public int y;

        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

}
