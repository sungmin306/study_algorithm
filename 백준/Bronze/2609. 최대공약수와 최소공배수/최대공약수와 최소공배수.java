
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        if(a < b) return gcd(b,a);
        return gcd(b,a%b);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int gcd = gcd(n,m);
        int lcm = (n * m) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
