

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int M,N,u,v;

    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] visited;
    //public static boolean check;


    public static void dfs(int d) {
        visited[d] = true;
        for(int i = 0; i < arrayList.get(d).size(); i++) {
            if(!visited[arrayList.get(d).get(i)]) {
                //check = true;
                dfs(arrayList.get(d).get(i));
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
                dfs(i);
                result++;
            }
        }
        System.out.println(result);

    }
}
