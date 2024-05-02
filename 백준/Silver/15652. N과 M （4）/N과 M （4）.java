
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;

    public static StringBuilder sb = new StringBuilder();

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void print() {
        for(int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i)).append(" ");
        }
    }

    public static void dfs(int h, int v) {

        if(h == m + 1) {
            print();
            sb.append("\n");
            return;
        }

        for(int i = v; i <= n; i++) {
            arrayList.add(i);
            dfs(h + 1,i);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(1,1);

        System.out.println(sb);

    }
}
