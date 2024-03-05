package baekjoon.Q1.b9375;

import java.io.*;
import java.util.*;


public class B9375Ver2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                if(hashMap.containsKey(kind)) {
                   hashMap.put(kind,hashMap.get(kind) + 1);
                }
                else {
                    hashMap.put(kind,1);
                }
            }
            int sum = 1;
            for(int s : hashMap.values()) {
                sum *= (s+1);
            }
            sum = sum -1;
            System.out.println(sum);
        }
    }
}
