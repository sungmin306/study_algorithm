
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] arr = new int[100001];
    public static int[] parent = new int[100001];

    public static boolean inRange(int n) {
       return 0 <= n && n <= 100000;
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;
        parent[n] = -1; // 처음위치

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                return;
            }

            int[] dx = {now - 1, now + 1, now * 2};
            for (int next : dx) {
                if (inRange(next) && arr[next] == 0) {
                    queue.add(next);
                    arr[next] = arr[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        sb.append(arr[K] - 1).append("\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        while(K != N) {
            stack.push(parent[K]);
            K = parent[K];
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);



    }
}
