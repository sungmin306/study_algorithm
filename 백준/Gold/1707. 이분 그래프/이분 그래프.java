

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] check;
    public static ArrayList<ArrayList<Integer>> arrayList;
    public static boolean[] visited;

    public static boolean bfs(int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(d);
        visited[d]  = true;
        check[d] = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < arrayList.get(now).size(); i++) {
                if(!visited[arrayList.get(now).get(i)]) {
                    visited[arrayList.get(now).get(i)] = true;
                    queue.add(arrayList.get(now).get(i));
                    check[arrayList.get(now).get(i)] = - check[now];
                }
                else {
                    if(check[now] == check[arrayList.get(now).get(i)]) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            check = new int[V + 1];
            visited = new boolean[V + 1];
            arrayList = new ArrayList<>();
            for(int j = 0; j < V + 1; j++) {
                arrayList.add(new ArrayList<>());
            }
            int E = Integer.parseInt(st.nextToken());

            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arrayList.get(u).add(v);
                arrayList.get(v).add(u);
            }
            boolean check2 = true;
            for(int j  = 1; j < V + 1; j++) {
                if(!visited[j]) {
                    if(!bfs(j)){
                        System.out.println("NO");
                        check2 = false;
                        break;
                    }
                }
            }
            if(check2) System.out.println("YES");
        }
    }
}
