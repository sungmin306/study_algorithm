package baekjoon.Q1.b2636;

import java.util.*;
import java.io.*;
public class B2636 {

    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int resultHour = 0;
    public static ArrayList<Integer> resultCheeseCounts = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int firstCheeseCount = countCheese();
        while(true) {
            resultHour++;
            visited = new boolean[n][m];
            bfs(0,0);
            int cnt = countCheese();
            if (cnt == 0) {
                break;
            }
            else {
                resultCheeseCounts.add(cnt);
            }
            removeCheese();
        }
        System.out.println(resultHour);
        if (resultCheeseCounts.size() > 0)
            System.out.println(resultCheeseCounts.get(resultCheeseCounts.size() - 1));
        else System.out.println(firstCheeseCount);


    }

    public static void bfs(int x, int y) { // 외부 공기 접촉
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                }
                if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {// 치즈 발견
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = -1;
                }
            }
        }
    }

    public static void removeCheese() { // 치즈 제거

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                }
            }
        }

    }
    public static int countCheese() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                if(map[i][j] == 1) count++;
        }
        return count;
    }
}
