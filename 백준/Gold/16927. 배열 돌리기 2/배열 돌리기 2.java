

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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


        int newN = n;
        int newM = m;
        for (int i = 0; i < Math.min(n,m) / 2; i++) {
            int a = r % (2 * newN + 2 * newM - 4);
            for (int j = 0; j < a; j++) {
                int x = i;
                int y = i;
                int dirNum = 0;
                int temp = map[x][y];

                while(dirNum < 4) {
                    int nx = x + dx[dirNum];
                    int ny = y + dy[dirNum];

                    if(CustominRange(nx,ny,i)) {
                        int temp2 = map[nx][ny];
                        map[nx][ny] = temp;
                        temp = temp2;
                        x = nx;
                        y = ny;
                        //System.out.println(Arrays.deepToString(map));
                    }
                    else {
                        dirNum++;
                    }
                }
            }
            newN = newN - 2;
            newM = newM - 2;
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
