package baekjoon.direct.b2636;

import java.io.*;
import java.util.*;

public class B2636 {

    public static int n;
    public static int m;

    public static int[][] map;
    public static boolean[][] visited;

    public static final int[] dx = {0, 0, -1, 1};
    public  static final int[] dy = {1, -1, 0, 0};
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int time = 0;
        int firstCount = getCount();

        while (flag) {
            time++;
            bfs(new Location(0, 0));
            for (int i = 0; i < n; i++)
                Arrays.fill(visited[i], false);
            int count = getCount();
            if (count == 0)
                flag = false;
            else
                list.add(count);
        }

        System.out.println(time);

        if (list.size() > 0) System.out.println(list.get(list.size() - 1));
        else System.out.println(firstCount);

    }

    static void bfs(Location location) {

        Queue<Location> queue = new LinkedList<>();
        queue.add(location);
        visited[location.x][location.y] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) {
                            map[nx][ny] = 2;
                            visited[nx][ny] = true;
                        }
                        if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            queue.add(new Location(nx, ny));
                        }
                    }
                }
            }
        }

        removeCheese(); // 배열의 값이 2면 치즈의 모서리이므로 0으로 바꾸어 녹여버림
    }

    static void removeCheese() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }

    static int getCount() {

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }

}


