import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int i = N - 1;
        while(i > 0 && arr[i - 1] >= arr[i]) i--;

        if(i == 0) {
            System.out.println(-1);
            return;
        }
        int j = N - 1;
        while (arr[i - 1] >= arr[j]) j--;

        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;

        int l = i, r = N - 1;
        while (l < r) {
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < N; k++) {
            sb.append(arr[k]);
            if (k + 1 < N) sb.append(' ');
        }
        System.out.println(sb);



    }
}
