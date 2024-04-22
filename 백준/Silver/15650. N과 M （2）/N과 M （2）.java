
import java.util.*;
import java.io.*;

public class Main {

    public static int n, m;

    public static ArrayList<Integer> arrayList = new ArrayList<>();


    public static void print() {
        for(int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }

    public static void dfs(int v, int h) {
        if(h == m + 1) {
            print();
            return;
        }
        for(int i = v; i <= n; i++) {
            arrayList.add(i);
            dfs(i + 1, h + 1);
            arrayList.remove(arrayList.size() - 1);

        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(1,1);
    }
}
