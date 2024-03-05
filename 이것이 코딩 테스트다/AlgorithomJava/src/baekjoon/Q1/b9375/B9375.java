package baekjoon.Q1.b9375;

import java.util.*;
import java.io.*;

public class B9375 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            HashMap<String,Integer> hashMap = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            int result = 1;
            for(int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String kind = st.nextToken();
                if(hashMap.containsKey(kind)) {
                    hashMap.put(kind, hashMap.get(kind)+ 1);
                }
                else {
                    hashMap.put(kind,1);
                }
            }
            for(int val :hashMap.values()) {
                result *= (val+1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}
