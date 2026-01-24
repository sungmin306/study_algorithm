import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int k;
    public static char[] arr;
    public static boolean[] visit = new boolean[10];
    public static ArrayList<String> arrayList = new ArrayList<>();

    public static void dfs(int now, int count, String number) {
        if(count == k) {
            arrayList.add(number);
            return;
        }

        for(int next = 0; next < 10; next++) {
            if(!visit[next]) {
                if((arr[count] == '<' && now < next) || (arr[count] == '>' && now > next)) {
                    visit[next] = true;
                    dfs(next, count + 1, number+next);
                    visit[next] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[k];

        for(int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for(int i = 0; i < 10; i++) {
            visit[i] = true;
            dfs(i,0,i+"");
            visit[i] = false;
        }

        System.out.println(arrayList.get(arrayList.size() - 1));
        System.out.println(arrayList.get(0));

    }
}
