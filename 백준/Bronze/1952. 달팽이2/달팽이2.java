import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;
    public static final int DIR_NUM = 4;

    public static int n, m;
    public static int[][] arr = new int[MAX_NUM][MAX_NUM];
    
    public static int[] dx = new int[]{0, 1,  0, -1};
    public static int[] dy = new int[]{1, 0, -1,  0};

    public static int currX = 0, currY = 0; 
    public static int dir = 0;              

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr[currX][currY] = 1;
        
        int cnt = 0;

        for(int i = 2; i <= n * m; i++) {

            int nextX = currX + dx[dir], nextY = currY + dy[dir];


            if(!inRange(nextX, nextY) || arr[nextX][nextY] != 0) {
                dir = (dir + 1) % 4;
                cnt++;
            }


            currX = currX + dx[dir]; currY = currY + dy[dir];
            arr[currX][currY] = i;
        }
        
        System.out.println(cnt);
    }
}