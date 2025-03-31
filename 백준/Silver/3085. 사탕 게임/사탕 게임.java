import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n, max;
    public static char[][] map;

    public static void check() {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n-1; j++) {
                if (map[i][j] == map[i][j+1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (max < cnt)
                    max = cnt;
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 0; i < n-1; i++) {
                if (map[i][j] == map[i+1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (max < cnt)
                    max = cnt;
            }
        }
    }

    public static void change(int a, int b) {
        char temp = map[a][b];
        map[a][b] = map[a][b+1];
        map[a][b+1] = temp;
    }

    public static void change2(int i, int j) {
        char temp = map[j][i];
        map[j][i] = map[j+1][i];
        map[j+1][i] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = 0;
        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        check();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-1; j++) {
                // 행 바꾸기
                change(i, j);
                check();
                change(i,j); // rollback
                // 열 바꾸기
                change2(i,j);
                check();
                change2(i,j); // roll back
            }
        }
        System.out.println(max);
    }
}
