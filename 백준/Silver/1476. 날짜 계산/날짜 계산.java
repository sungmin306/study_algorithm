import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX_E = 15;
    public static final int MAX_S = 28;
    public static final int MAX_M = 19;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int E, S, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int compareE = 1, compareS = 1, compareM = 1;
        int result = 1;
        while(true) {
            if(compareE == E && compareS == S && compareM == M) {
                System.out.println(result);
                break;
            }
            compareE++;
            compareS++;
            compareM++;
            if (compareE > MAX_E) compareE = 1;
            if (compareS > MAX_S) compareS = 1;
            if (compareM > MAX_M) compareM = 1;
            result++;
        }

    }
}
