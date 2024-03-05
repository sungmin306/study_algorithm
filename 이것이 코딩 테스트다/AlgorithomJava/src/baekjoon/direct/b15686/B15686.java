package baekjoon.direct.b15686;

import java.io.*;
import java.util.*;

public class B15686 {

    public static int n;
    public static int m;
    public static int result;
    public static int[][] map;
    public static boolean[] open;
    public static ArrayList<int[]> house;
    public static ArrayList<int[]> chicken;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j  = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) house.add(new int[] {i,j});
                else if(map[i][j] == 2) chicken.add(new int[] {i,j});
            }
        }
        result = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(result);
    }
    public static void dfs(int start, int cnt) {
        if (cnt == m) {
            int totalDistance = 0;
            for(int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(open[j]) {
                        int distance = Math.abs(house.get(i)[0] - chicken.get(j)[0])
                                + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
                        temp = Math.min(temp, distance);
                    }
                }
                totalDistance += temp;
            }
            result = Math.min(totalDistance, result);
            return;
        }

        for(int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}
