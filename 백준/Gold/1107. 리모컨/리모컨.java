import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] broken = new boolean[10];

    public static boolean canType(int x) {
        if (x == 0) return !broken[0];
        while(x > 0) {
            int d = x % 10;
            if(broken[d]) return false;
            x = x / 10;
        }
        return true;
    }

    public static int digits(int x) {
        if(x == 0) return 1;
        int cnt = 0;
        while(x > 0) {
            cnt++;
            x = x / 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for(int ch = 0; ch <= 999999; ch++) {
            if (!canType(ch)) continue;
            int press = digits(ch) + Math.abs(N -ch);
            if (press < ans) ans = press;
        }

        System.out.println(ans);

    }
}
