import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int total = 0;
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int output = Integer.parseInt(st.nextToken());
            int input = Integer.parseInt(st.nextToken());

            total -= output;
            total += input;

            if(max < total) max = total;
        }
        System.out.println(max);
    }
}
