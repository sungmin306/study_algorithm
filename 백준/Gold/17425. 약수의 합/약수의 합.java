import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final int MAX = 1000001;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] arr = new long[1000001]; // 약수합
        Arrays.fill(arr,1);
        for(int i = 2; i < MAX; i++) {
            for(int j = 1; i*j < MAX; j++) {
                arr[i*j] += i;
            }
        }
        long[] prefixSum = new long[1000001];
        prefixSum[1] = arr[1];
        for(int i = 2; i < 1000001; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(prefixSum[n]).append("\n");
        }
        System.out.println(sb);




    }
}
