import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        sb.append('<');
        while(queue.size() > 1) {
            for(int i = 0; i < K - 1; i++) { // queue를 빼서 맨 밑으로 넣는다.
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append('>'); // K 번째 숫자를 빼서 출력한다.
        System.out.println(sb);
    }
}
