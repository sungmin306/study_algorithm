
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, D;
    public static ArrayList<List<Node>> graph = new ArrayList<>();
    public static int[] dist;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curPos = current.end;
            int curDist = current.distance;

            if (curDist > dist[curPos]) continue;

            for (Node neighbor : graph.get(curPos)) {
                int newDist = curDist + neighbor.distance;

                if (newDist < dist[neighbor.end]) {
                    dist[neighbor.end] = newDist;
                    pq.add(new Node(neighbor.end, newDist));
                }
            }

            if (curPos + 1 <= D && curDist + 1 < dist[curPos + 1]) {
                dist[curPos + 1] = curDist + 1;
                pq.add(new Node(curPos + 1, curDist + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (e <= D) {  // 목적지 범위 내의 경우에만 추가
                graph.get(s).add(new Node(e, d));
            }
        }
        dijkstra(0);

        System.out.println(dist[D] == Integer.MAX_VALUE ? -1 : dist[D]);
    }
}

class Node {
    int end;
    int distance;

    public Node(int end, int distance) {
        this.end = end;
        this.distance = distance;
    }
}
