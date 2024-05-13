
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;
        int distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {-1,-1,-1,0,0,1,1,1};
    public static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static int result = Integer.MIN_VALUE;

    public static ArrayList<int[]> arrayList = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static int bfs(int x, int y) {
        visited = new boolean[N][M];
        visited[x][y] = true;
        int returnValue = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            if(map[nowX][nowY] == 1) {
                returnValue = now.distance;
                break;
            }

            for(int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(inRange(nextX,nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX,nextY,now.distance + 1));
                }

            }
        }
        return returnValue;
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    result = Math.max(result, bfs(i,j));
                }
            }
        }
        System.out.println(result);
    }
}