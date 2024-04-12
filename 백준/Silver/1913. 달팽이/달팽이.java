
import java.io.*;


public class Main {
    public static int n, m;
    public static int x, y;
    public static int[][] map;
    public static int dirNum = 0;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n][n];

        x = n / 2;
        y = n / 2;
        int num = 1;
        map[x][y] = num;

        int move = 1;
        int returnX = 0;
        int returnY = 0;

        while(inRange(x,y)) {

            for(int i = 0; i < move; i++) {
                map[x][y] = num;
                if(num == m) {
                    returnX = x + 1;
                    returnY = y + 1;
                }
                num++;
                x = x + dx[dirNum];
                y = y + dy[dirNum];
                if(!inRange(x,y)) break;
                map[x][y] = num;
            }
            dirNum = (dirNum + 1) % 4;

            if(dirNum == 0 || dirNum == 2) {
                move++;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(returnX + " " + returnY);
        bw.flush();
        bw.close();
    }
}
