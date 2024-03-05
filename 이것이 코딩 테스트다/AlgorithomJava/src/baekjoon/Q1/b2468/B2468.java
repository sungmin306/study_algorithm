package baekjoon.Q1.b2468;

import java.io.*;
import java.util.*;
public class B2468 {

    public static int n;
    public static int[][] region;
    public static boolean[][] visited;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int max = 0;
        int result = 0;
        region = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                if (max < region[i][j]) max = region[i][j];
            }
        }
        for(int i = 0; i < max+1; i++) {
            for(int j = 0; j < n; j++) { // 1 ~ max 비오는날 잠기기
                for(int k = 0; k < n;k++) {
                    region[j][k] -= i;
                }
            }
            int cnt = 0;
            visited = new boolean[n][n];
            for(int j = 0; j < n; j++) {
                for(int k = 0;  k < n; k++) {
                    if(!visited[j][k] && region[j][k] >0){
                        cnt+= bfs(j,k);
                    }
//                    System.out.println(Arrays.deepToString(visited));
//                    System.out.println(cnt);
                }
            }
//            System.out.println(cnt);
            result = Math.max(result,cnt);
        }
        System.out.println(result);
    }
    public static int bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a,b});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
//            System.out.println("while 문 들어옴");
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
//                System.out.println("for문 들어옴");
//                System.out.println(nextX);
//                System.out.println(nextY);
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
//                    System.out.println("continu조건문 들어옴");
                    continue;
                }
//                System.out.println("continue 통과함");
                if(region[nextX][nextY] > 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
//                    System.out.println("조건문 들어옴");
                    queue.add(new int[] {nextX,nextY});
                }
            }
        }
        return 1;
    }


}
