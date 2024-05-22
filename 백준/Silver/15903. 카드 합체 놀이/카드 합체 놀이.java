

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        for(int i = 0; i < m; i++) {
            long sum = 0;
            sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        long result = 0;
        for(int i = 0; i < n; i++) {
            result += pq.poll();
        }
        System.out.println(result);
    }
}
