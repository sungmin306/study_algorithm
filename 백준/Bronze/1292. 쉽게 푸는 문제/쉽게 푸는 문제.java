

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        int count = 1;
        for(int i = 1; i <= B; i++) {
            for(int j = 0; j < i; j++) {
                if(A <= count && count <= B) {
                    sum+=i;
                }
                count++;
            }
            if(count > B) break;
        }
        System.out.println(sum);
    }
}
