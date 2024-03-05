package baekjoon.Q2.b1620;

import java.util.*;
import java.io.*;
public class B1620 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer,String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            hashMap1.put(i+1, s);
            hashMap2.put(s,i+1);
        }
        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))) {
                sb.append(hashMap1.get(Integer.parseInt(s)) + "\n");
            }
            else {
                sb.append(hashMap2.get(s) + "\n");

            }
        }
        System.out.println(sb);
    }
}
