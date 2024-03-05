
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 {

    public static int n,m;
    public static int a,b;
    public static int max;
    public static int[] count;
    public static boolean[] visited;
    public static ArrayList<Integer>[] arr;


    public static void BFS(int s) {
        Queue<Integer> queue = new ArrayDeque<Integer>();

        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i : arr[now]) {
                if (visited[i]) continue;
                count[i]++;
                visited[i] = true;
                queue.add(i);
            }
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = new int[n+1];

        arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) arr[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }
        for(int i = 1; i < n+1; i++) {
            visited = new boolean[n+1];
            BFS(i);
        }

        int max = 0;
        //int max = Arrays.stream(count).max().getAsInt();
        for(int i = 1; i < n+1; i++) {
            if(max < count[i]) max = count[i];
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < n+1; i++) {
            if (max == count[i]) sb.append(i + " ");
        }
        System.out.println(sb.toString().trim());


    }

}
//public class B1325 {
//
//    public static int n,m;
//    public static int a,b;
//    public static int[] countList;
//
//
//    public static void main(String[] args)throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        countList = new int[n + 1];
//        ArrayList<Trust> trusts = new ArrayList<>();
//        for(int i = 0; i < n+1; i++) {
//            trusts.add(new Trust());
//        }
//        for(int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//            trusts.get(b).count++;
//            trusts.get(b).arrayList.add(a);
//        }
//        for(int i = 1; i < n+1; i++) {
//            Trust t = trusts.get(i);
//            countList[i] += t.count;
//            for(int j = 0; j < t.arrayList.size(); j++) {
//                countList[i] += trusts.get(t.arrayList.get(j)).count;
//            }
//        }
//        int max = Arrays.stream(countList).max().getAsInt();
//
//        for(int i = 0; i < n+1; i++) {
//            if (max == countList[i]) {
//                System.out.print(i + " ");
//            }
//        }
//    }
//}
//
//class Trust {
//    public int count;
//    public ArrayList<Integer> arrayList;
//
//    public Trust() {
//        this.count = 0 ;
//        this.arrayList = new ArrayList<>();
//    }
//}
