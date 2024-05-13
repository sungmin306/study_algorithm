
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N, M, V;
    public static int u,v;
    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] visitedDFS;
    public static boolean[] visitedBFS;


    public static int cntDFS = 1;
    public static int cntBFS = 1;

    public static void dfs(int r) {
        System.out.print(r + " ");
        visitedDFS[r] = true;
        for(Integer e : arrayList.get(r)) {
            if(!visitedDFS[e]){
                dfs(e);
            }
        }

    }

    public static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visitedBFS[r] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for(Integer e : arrayList.get(temp)) {
                int nextValue = e;
                if(!visitedBFS[nextValue]) {
                    queue.add(nextValue);
                    visitedBFS[nextValue] = true;
                }

            }
        }

    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N + 1];
        visitedBFS = new boolean[N + 1];
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

        for(int i = 1; i <arrayList.size(); i++) Collections.sort(arrayList.get(i));
        dfs(V);
        System.out.println();
        bfs(V);



    }
}
