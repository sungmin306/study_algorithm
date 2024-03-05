package baekjoon.Q1.b1068;
import java.io.*;
import java.util.*;

public class B1068 {
    public static int n, m;
    public static int[] parents;
    public static boolean[] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        removeNode(m);
        System.out.println(countLeafNode());
    }

    public static void removeNode(int m) {
        parents[m] = -2;
        visited[m] = true;
        for(int i = 0; i < n; i++) {
            if(parents[i] == m) removeNode(i);
        }
    }
    public static int countLeafNode() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(isLeafNode(i)) cnt++;
        }
        return cnt;
    }
    public static boolean isLeafNode(int index) {
        //visited[index] = true;
        boolean result = true;
        for(int i = 0; i < n; i++) {
            if(parents[i] == index) {
                result = false;
                break;
            }
        }
        return result;
    }


}

