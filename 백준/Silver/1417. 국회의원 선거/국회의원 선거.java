
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static int N;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static int election(int dasom) {
        if(N == 1) return 0;
        int cnt = 0;
        while(true) {
            int temp = pq.poll();
            if(dasom > temp) {
                break;
            }
            dasom+=1;
            temp -=1;
            pq.add(temp);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        for(int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(election(dasom));
    }
}
