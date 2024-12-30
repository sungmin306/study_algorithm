

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.plaf.IconUIResource;

public class Main {

    public static int N, count;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x , int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    public static void dfs(int x, int y) {
        count++;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx,ny) && !visited[nx][ny] && map[nx][ny]==1) {
                dfs(nx,ny);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int houses = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j =0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    count = 0;
                    dfs(i,j);
                    arrayList.add(count);
                    houses++;
                }
            }
        }
        sb.append(houses).append("\n");
        arrayList.sort((a,b) -> Integer.compare(a,b));
        for(int e : arrayList) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);

    }
}
