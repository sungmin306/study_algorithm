import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int total = 0;
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        Arrays.sort(arr);
        boolean check = false;
        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                int sum = total - arr[i] - arr[j];
                if(sum == 100) {
                    for(int k = 0; k < 9; k++) {
                        if(k != i && k != j) {
                            sb.append(arr[k]).append("\n");
                        }
                    }
                    check = true;
                    break;
                }
            }
            if(check) break;

        }
        System.out.println(sb);
    }
}
