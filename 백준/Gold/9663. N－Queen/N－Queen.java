

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static int[] arr;
    public static int result = 0;

    public static boolean check(int n) {
       for(int i = 0; i < n; i++) {
           if (arr[n] == arr[i]) return false;
           else if(Math.abs(n - i) == Math.abs(arr[n] - arr[i])) return false;
       }
       return true;
    }

    public static void dfs(int d) {
        if(d == N) {
            result++;
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[d] = i;
            if(check(d)) dfs(d + 1);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N];

        dfs(0);
        System.out.println(result);

    }
}
