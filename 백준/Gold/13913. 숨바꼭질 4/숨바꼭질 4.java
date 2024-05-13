

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void bfs(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visited[n] = true;
        parent[n] = -1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) {
                return;
            }

            int[] nextPositions = {x - 1, x + 1, x * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    parent[next] = x;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        ArrayList<Integer> path = new ArrayList<>();
        int current = K;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        System.out.println(path.size() - 1);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}
