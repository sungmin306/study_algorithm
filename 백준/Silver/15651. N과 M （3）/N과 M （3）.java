

import java.util.*;
import java.io.*;

public class Main {

    public static int n, m;
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void print() {
        for(int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(" ");
        }
        sb.append("\n");
    }
    public static void dfs(int h) {
        if(h == m + 1) {
            print();
            return;
        }
        for(int i = 1; i <= n; i++) {
            arrayList.add(i);
            dfs(h + 1);
            arrayList.remove(arrayList.size() - 1);
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(1);

        System.out.println(sb);

    }
}
