

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, K;
    public static boolean[] visited = new boolean[100001];
    public static int cnt = 0;
    public static int[] arr = new int[1000001];

    public static boolean inRange(int n) {
        return 0 <= n && n <= 100000;
    }

    public static int bfs(int n) {
        visited[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int returnValue = 0;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == K) {
                returnValue = arr[now];
                break;
            }
            int next = now + 1;
            if(inRange(next) && !visited[next]) {
                queue.add(next);
                visited[next] = true;
                arr[next] = arr[now] + 1;
            }
            next = now - 1;
            if(inRange(next) && !visited[next]) {
                queue.add(next);
                visited[next] = true;
                arr[next] = arr[now] + 1;
            }
            next = now * 2;
            if(inRange(next) && !visited[next]) {
                queue.add(next);
                visited[next] = true;
                arr[next] = arr[now] + 1;
            }
        }
        return returnValue;
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));





    }
}
