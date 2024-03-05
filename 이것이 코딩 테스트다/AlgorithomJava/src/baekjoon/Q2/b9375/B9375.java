package baekjoon.Q2.b9375;

import java.util.*;
import java.io.*;
public class B9375 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 앞글자 버리기
                String s = st.nextToken();
                if(hashMap.containsKey(s)) {
                    hashMap.put(s, hashMap.get(s) + 1); // 기존에 있는 Put하면 기존 값 없어지고 새로운 put 됨 hashMap key 중복 x 이용
                }
                else {
                    hashMap.put(s,2); // 처음 아무것도 안입는거 생각해서 2로 시작
                }
            }
            int sum = 1;
            for(String s : hashMap.keySet()) {
                sum *= hashMap.get(s);
            }
            sum = sum -1; // 아무것도 안입는 경우의 수 빼기
            sb.append(sum).append("\n");
        }
        System.out.println(sb);


    }
}
