package baekjoon.direct.b9375;

import java.util.*;
import java.io.*;

public class B9375 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T -- > 0) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String kind = st.nextToken();

                if (hashMap.containsKey(kind)) {
                    hashMap.put(kind, hashMap.get(kind) + 1); // key 값이 중복안되는 것을 이용
                }
                else {
                    hashMap.put(kind, 1);
                }
            }
            int result = 1;
            for (int val : hashMap.values()) {
                result *= (val + 1); // NuLL 값을 생각해서 + 1
            }
            sb.append(result - 1).append('\n'); // 모두 NULL값인 경우 -1

        }
        System.out.println(sb);
    }
}
