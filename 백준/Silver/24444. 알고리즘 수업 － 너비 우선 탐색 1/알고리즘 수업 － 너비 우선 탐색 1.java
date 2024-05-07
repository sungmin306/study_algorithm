

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M, R;
    public static int u,v;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();


    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;

        queue.add(r);
        visited[r] = true;
        arr[r] = cnt++;

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int i = 0; i < graph.get(temp).size(); i++) {
                int nextValue = graph.get(temp).get(i); // nextValue

                if(!visited[nextValue]) {
                    queue.add(nextValue);
                    visited[nextValue] = true;
                    arr[nextValue] = cnt++;
                }
            }
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i <= N; i++) Collections.sort(graph.get(i));
        bfs(R);
        for(int i = 1; i <= N; i++) System.out.println(arr[i]);
    }
}
