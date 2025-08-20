import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            boolean check = true;
            for(int j = 2; j <=n/2; j++) {
                if(n % j == 0) {
                    check = false;
                    break;
                }
            }
            if(check && n !=1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
