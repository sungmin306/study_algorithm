
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    public static boolean[] visited;
    public static int check = 0;

    public static void dfs(int s, int d) {
        if(d == 5) {
            check = 1;
            return;
        }
        visited[s] = true;
        for(int i : arrayList.get(s)) {
            int next = i;
            if(!visited[next]) dfs(next, d + 1);
        }
        visited[s] = false;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for(int i = 0; i < N; i++) {
            arrayList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        for(int i = 0; i < N; i++) {
            if(check == 0) dfs(i,1);
        }
        System.out.println(check);
    }
}
