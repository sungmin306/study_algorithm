import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int S = 0;
        StringTokenizer st;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;
            switch(str) {
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    S |= (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    S &= ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                    break;
                default:
                    num = Integer.parseInt(st.nextToken());
                    S ^= (1 << num);
                    break;
            }
        }
        System.out.println(sb);
    }
}
