package baekjoon.Q1.b1992;

import com.sun.security.jgss.GSSUtil;
import java.util.*;
import java.io.*;
public class B1992 {

    public static int n;
    public static int[][] quadTree;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        quadTree = new int[n][n];

        for(int i = 0; i < n; i++) { // quadTree 입력
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                quadTree[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(0,0,n);
        System.out.println(sb);
    }

    public static void dfs(int a, int b, int n) {

        if(check(n,a,b)) {
            sb.append(quadTree[a][b]);
            return;
        }
        int half = n / 2;

        sb.append("(");
        dfs(a, b, half);
        dfs(a, b +half , half);
        dfs(a + half, b, half);
        dfs(a + half, b + half, half);
        sb.append(")");



    }

    public static boolean check(int half, int c, int r) {
        int value = quadTree[c][r];
        for(int i = c; i < c + half; i++) {
            for(int j = r; j < r + half; j++) {
                if(value != quadTree[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
