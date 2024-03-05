package baekjoon.direct.b4179;

import java.util.*;
import java.io.*;
public class B4179 {

    public static int R;
    public static int C;
    public static char[][] miro;
    public static boolean[][] visited;
    public static boolean[][] fireVisited;
    public static Queue<Node> fires;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int distance;
    public static boolean check;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        miro = new char[R][C];
        visited = new boolean[R][C];
        fireVisited = new boolean[R][C];
        fires = new LinkedList<>();
        int x = 0;
        int y = 0;
        for(int i = 0; i <R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                miro[i][j] = s.charAt(j);
                if(miro[i][j] == 'J') { // 지훈 위치 저장
                    x = i;
                    y = j;
                    visited[x][y] = true;
                }
                if(miro[i][j] == 'F') {
                    fireVisited[i][j] = true;
                    fires.add(new Node(i,j));

                }
            }
        }
        check = false;
        bfs(x,y);
        if(!check) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        distance = 0;
        check = false;
        while(!queue.isEmpty()) {
            moveFire();
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {

                Node now = queue.poll();
                int nowX = now.x;
                int nowY = now.y;

                for(int j = 0; j < 4; j++) {
                    int nextX = nowX + dx[j];
                    int nextY = nowY + dy[j];
                    if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                        distance++;
                        System.out.println(distance);
                        check = true;
                        return;
                    }
                    if(miro[nextX][nextY] == '.' && !visited[nextX][nextY]) {

                        visited[nextX][nextY] = true;
                        queue.add(new Node(nextX,nextY));
                    }
                }
            }
            distance++;
        }
    }
    public static void moveFire() {
        int firesSize = fires.size();
        for(int i = 0; i < firesSize; i++) {
            Node nowFire = fires.poll();
            int nowFireX = nowFire.x;
            int nowFireY = nowFire.y;
            for(int j = 0; j < 4; j++) {
                int nextFireX = nowFireX + dx[j];
                int nextFireY = nowFireY + dy[j];

                if(nextFireX < 0 || nextFireY < 0 || nextFireX >= R || nextFireY >= C) continue;
                if(miro[nextFireX][nextFireY] != '#' && !fireVisited[nextFireX][nextFireY]) {
                    fireVisited[nextFireX][nextFireY] = true;
                    miro[nextFireX][nextFireY] = 'F';
                    fires.add(new Node(nextFireX,nextFireY));
                }
            }
        }
    }
}



class Node{
    public int x;
    public int y;


    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }


}

