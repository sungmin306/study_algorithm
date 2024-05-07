import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] DP = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            DP[i] = DP[i-1] + Integer.parseInt(st.nextToken());
        }
        int result = -100000;
        for(int i = k;  i < n+1; i++) {
            int sum = DP[i] - DP[i-k];
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}
