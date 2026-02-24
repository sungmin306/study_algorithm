import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) number[i] = Integer.parseInt(st.nextToken());

        int idx = N - 1;
        while(idx > 0 && number[idx] > number[idx -1]) idx --;

        if(idx == 0) {
            System.out.println(-1);
            return;
        }

        int j = N - 1;
        while(number[j] > number[idx - 1]) j--;

        int tmp;
        tmp = number[idx - 1];
        number[idx -1] = number[j];
        number[j] = tmp;

        int l = idx;
        int r = N - 1;

        while(l < r) {
            tmp = number[l];
            number[l] = number[r];
            number[r] = tmp;
            l++;
            r--;
        }

        for(int i = 0; i < N; i++) {
            sb.append(number[i]).append(" ");
        }
        System.out.println(sb);


    }
}
