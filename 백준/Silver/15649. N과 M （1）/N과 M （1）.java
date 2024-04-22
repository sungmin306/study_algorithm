import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static boolean[] visited;

    public static void print() {
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }
    public static void dfs(int h) {
        if(h == m + 1) {
            print();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;

            arrayList.add(i);
            visited[i] = true;
            dfs(h + 1);
            arrayList.remove(arrayList.size() - 1);
            visited[i] = false;
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        dfs(1);



    }
}
