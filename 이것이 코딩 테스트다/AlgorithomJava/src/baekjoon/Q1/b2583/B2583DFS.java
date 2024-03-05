package baekjoon.Q1.b2583;

import java.util.*;
import java.io.*;

public class B2583DFS {
    public static int n, m, k;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {-1,1,0,0};
    public static int h;
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st2.nextToken());
            int x1 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());

            for(int a = x1; a < x2; a++) {
                for(int b = y1; b < y2; b++) {
                    map[a][b] = 1;
                }
            }
        }
        int cnt = 0;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 0){
                    h=1;
                    cnt+= dfs(i,j);
                    arrayList.add(h);
                }
            }
        }
        //System.out.println(Arrays.deepToString(map));
        System.out.println(cnt);
        //arrayList.sort(null);
        Collections.sort(arrayList);
        for(int i = 0; i < arrayList.size(); i++) {
            //arrayList.get(i);
            System.out.print(arrayList.get(i) + " ");
        }
    }
    public static int dfs(int a, int b) {
        visited[a][b] = true;

        for(int i = 0; i < 4; i++) {
            int nextX = a + dx[i];
            int nextY = b + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
            if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                h++;
                visited[nextX][nextY] = true;
                dfs(nextX,nextY);
            }
        }
        return 1;
    }
}
