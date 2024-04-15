
import java.util.*;
import java.io.*;


public class Main {
    public static int n;
    public static int m;
    public static int r;
    public static int[][] map;

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static boolean CustominRange(int x, int y, int num) {
        return (0 + num) <= x && x < (n - num) && (0 + num) <= y && y < (m - num);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int min = Math.min(n,m);
        for (int i = 0; i < r; i++) {
            for(int j = 0; j < min/2; j++) {
                int x = j;
                int y = j;

                int temp = map[x][y];
                int moveDir = 0;
                while(moveDir < 4) {
                    int nx = x + dx[moveDir];
                    int ny = y + dy[moveDir];

                    if(CustominRange(nx,ny,j)) {
                        int temp2 = map[nx][ny];
                        map[nx][ny] = temp;
                        temp = temp2;
                        x = nx;
                        y = ny;
                        //System.out.println(Arrays.deepToString(map));
                    }
                    else {
                        moveDir++;
                    }
                }

            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
