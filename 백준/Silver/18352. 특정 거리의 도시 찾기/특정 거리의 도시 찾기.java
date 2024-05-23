
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, K, X;
    public static ArrayList<Node>[] arr;
    public static int[] dist;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int current = now.index;
            int currentDist = now.dist;

            if (dist[current] < currentDist) continue;

            for (Node next : arr[current]) {
                int newDist = currentDist + next.dist;
                if (newDist < dist[next.index]) {
                    dist[next.index] = newDist;
                    pq.add(new Node(next.index, newDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(new Node(B, 1));
        }

        dijkstra(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}

class Node implements Comparable<Node> {
    int index, dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return this.dist - other.dist;
    }
}
