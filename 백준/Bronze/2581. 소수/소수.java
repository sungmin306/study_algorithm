import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean isPrime(int a) {
        if(a < 2) return false;
        for(int i = 2; i <= a/2; i++) {
            if(a % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = N; i <= M; i++) {
            if(isPrime(i)) {
                if(min > i) min = i;
                sum += i;
            }
        }
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
