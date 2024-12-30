import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int M,N,u,v;

    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] visited;
    
    public static void bfs(int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(d);
        visited[d] = true;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int i = 0; i < arrayList.get(tmp).size(); i++) {
                if(!visited[arrayList.get(tmp).get(i)]) {
                    visited[arrayList.get(tmp).get(i)] = true;
                    queue.add(arrayList.get(tmp).get(i));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        int result = 0;
        for(int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            arrayList.get(u).add(v);
            arrayList.get(v).add(u);
        }

        for(int i = 1; i < N + 1; i++) {
            if(!visited[i]) {
                //dfs(i);
                bfs(i);
                result++;
            }
        }
        System.out.println(result);

    }
}

