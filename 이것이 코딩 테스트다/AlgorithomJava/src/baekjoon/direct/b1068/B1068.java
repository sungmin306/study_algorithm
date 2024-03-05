package baekjoon.direct.b1068;

import java.util.*;
import java.io.*;

public class B1068 {

    public static int n,remove;
    public static int[] parent;
    public static boolean[] visited;

    public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       n = Integer.parseInt(br.readLine());
       parent = new int[n];
       visited = new boolean[n];
       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i = 0; i < n; i++) {
           parent[i] = Integer.parseInt(st.nextToken());
       }
       remove = Integer.parseInt(br.readLine());
       removeNode(remove);
        System.out.println(cntLeafNode());

    }

    public static void removeNode(int r) {
        visited[r] = true;
        parent[r] = -2;

        for(int i = 0; i < n; i++) {
            if(parent[i] == r) removeNode(i);
        }
    }

    public static int cntLeafNode() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(ifLeafNode(i)) cnt++;
        }
        return cnt;
    }

    public static boolean ifLeafNode(int index) {
        visited[index] = true;
        boolean result = true;
        for(int i = 0; i < n; i++) {
            if(parent[i] == index) {
                result = false;
                break;
            }
        }
        return result;
    }

}
