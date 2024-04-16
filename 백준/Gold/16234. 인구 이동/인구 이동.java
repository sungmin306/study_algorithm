import java.io.*;
import java.util.*;


public class Main {

    public static int n;
    public static int L;
    public static int R;

    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<int[]> indexes;

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static boolean check;
    public static int resultDay;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(moveDay());
    }
    public static int moveDay() {
        resultDay = 0;
        while(true) {
            visited = new boolean[n][n];
            check = false;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        //visited[i][j] = true;
                        bfs(i,j);
                    }
                }
            }
            if(!check) return resultDay;
            resultDay++;
        }
    }
    public static void bfs(int x, int y) {
        indexes = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
                int d = Math.abs(map[nowX][nowY] - map[nextX][nextY]);
                if(!visited[nextX][nextY] && d >= L && d <= R) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                    indexes.add(new int[] {nextX, nextY});
                    check = true;
                }
            }
        }
        if(indexes.size() > 0){
            move();
        }
    }
    public static void move() {
        int sum = 0;
        for(int i = 0; i < indexes.size(); i++) {
            int x = indexes.get(i)[0];
            int y = indexes.get(i)[1];
            sum+= map[x][y];
        }
        int divideValue = sum / indexes.size();
        for(int i = 0; i < indexes.size(); i++) {
            int x = indexes.get(i)[0];
            int y = indexes.get(i)[1];
            map[x][y] = divideValue;
        }
    }
}
