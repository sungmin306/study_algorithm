import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean isPrime(int a) {
        if(a < 2) return false;
        for(int i = 2; i <= a/2; i++) {
            if(a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        boolean check = false;
        for(int i = M; i <=N; i++) {
            if(isPrime(i)) {
                check = true;
                if(min == 0) min = i;
                sum+= i;
            }
        }
        if (check) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
