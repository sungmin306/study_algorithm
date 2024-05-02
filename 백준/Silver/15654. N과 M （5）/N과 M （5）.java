
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;

    public static int[] arr;

    public static boolean[] visited;

    public static StringBuilder sb = new StringBuilder();

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void print() {
        for(int i = 0; i < m; i++) {
            sb.append(arrayList.get(i)).append(" ");
        }
    }

    public static void dfs(int h) {

        if(h == m) {
            print();
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            arrayList.add(arr[i]);
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

        visited = new boolean[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);

        System.out.println(sb);
    }
}
