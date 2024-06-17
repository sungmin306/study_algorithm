

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int d) {
        if(d == M) {
            for(int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            arrayList.add(i);
            dfs(d + 1);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
