package baekjoon.direct.b2589;

import java.io.*;
import java.util.*;


public class B2589 {

    public static int n;
    public static int m;
    public static char[][]map;
    public static boolean visited[][];
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int resultDistance = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    visited[i][j] = true; // 확인해보자
                    int result = bfs(i,j);
                    resultDistance = Math.max(result,resultDistance);
                }
            }
        }
        System.out.println(resultDistance);
    }

    public static int bfs(int x, int y) {
        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y,0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(!visited[nextX][nextY] && map[nextX][nextY] == 'L') {
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, now.distance+1));
                    result = Math.max(result, now.distance + 1);
                }
            }
        }
        return result;
    }
    public static class Node {
        public int x;
        public int y;
        public int distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }
}
