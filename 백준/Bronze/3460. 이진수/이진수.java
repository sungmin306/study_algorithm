import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());

            for(int i = 0; i < T; i++) {
                int n = Integer.parseInt(br.readLine());
                int index = 0;
                while(n != 0) {
                    if(n % 2 == 1) {
                        sb.append(index).append(" ");
                    }
                    n/=2;
                    index++;
                }
                sb.append("\n");
            }
        System.out.println(sb.toString());
    }
}
