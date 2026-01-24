import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int L, C;
    public static char[] arr;
    public static char[] m = {'a','e','i','o','u'};
    public static ArrayList<String> arrayList = new ArrayList<>();

    public static boolean check(String password) {
        int mCount = 0;
        int jCount = 0;
        for(int i = 0; i < L; i++) {
            char now = password.charAt(i);
            boolean mcheck = false;
            for(int j = 0; j < 5; j++) {
                if(m[j] == now) {
                    mCount++;
                    mcheck = true;
                    break;
                }
            }
            if(!mcheck) jCount++;
            if(mCount >= 1 && jCount >= 2) return true;
        }
        return false;
    }
    public static boolean isStringEqual(String password) {
        for(String s : arrayList) {
            if(s.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void dfs(int idx, int d, String password) {
        if(d == L) {
            char[] tmp = password.toCharArray();
            Arrays.sort(tmp);
            password = new String(tmp);
            if(!isStringEqual(password)){
                if(check(password))
                    arrayList.add(password);
            }
            return;
        }
        for(int i = idx + 1; i < C; i++) {
            dfs(i,d + 1, password + arr[i]);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[C];

        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        for(int i = 0; i < C; i++) {
            if((C - i) >= L) dfs(i, 1,"" + arr[i]);
        }
        for(String s : arrayList) {
            System.out.println(s);
        }
    }
}
