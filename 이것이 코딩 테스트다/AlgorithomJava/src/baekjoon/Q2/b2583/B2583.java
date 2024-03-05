package baekjoon.Q2.b2583;

import java.util.*;
import java.io.*;

public class B2583 {

    public static int n, m, k;
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<Integer> arrayList;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int cnt;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        arrayList = new ArrayList<>();
        for(int i = 0; i < k; i++) { // 입력
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int x = x1; x < x2; x++) {
                for(int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        //System.out.println(Arrays.deepToString(map));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <m; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    cnt = 1;
                    dfs(i,j);
                    arrayList.add(cnt);
//                    arrayList.add(bfs(i,j));
//                    visited[i][j] = true;
                }
            }

        }
        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
            if(!visited[newX][newY] && map[newX][newY] == 0) {
                cnt++;
                dfs(newX, newY);

            }
        }
    }
//    public static int bfs(int x, int y) {
//        int count = 0;
//        Queue<int[] > queue = new LinkedList<>();
//        queue.add(new int[] {x,y});
//        while(!queue.isEmpty()) {
//            System.out.println("while");
//            System.out.println(queue.size());
//            int[] now = queue.poll();
//            int nowX = now[0];
//            int nowY = now[1];
//            System.out.println("nowX " + nowX);
//            System.out.println("nowY " + nowY);
//            for(int i = 0; i < 4; i++) {
//                int nextX = nowX + dx[i];
//                int nextY = nowY + dy[i];
//                System.out.println("nextX " + nextX);
//                System.out.println("nextY " + nextY);
//                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
//                System.out.println(map[nextX][nextY]);
//                System.out.println(visited[nextX][nextY]);
//                if(!visited[nextY][nextY] && map[nextX][nextY] == 0) {
//                    visited[nextX][nextY] = true;
//                    queue.add(new int[] {nextX, nextY});
//                    count++;
//                }
//
//            }
//            System.out.println("count" + count);
//        }
//        return count;
//    }
}
