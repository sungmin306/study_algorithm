import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 0) System.out.println(0);
        else if (n == 1) System.out.println(1);
        else {
            int[] arr = new int[n];
            arr[0] = 1;
            arr[1] = 1;
            for(int i = 2; i <n; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[n-1]);
        }



    }
}
