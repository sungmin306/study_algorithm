package baekjoon.Q1.b2910;

import java.util.*;
import java.io.*;

public class B2910 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(a)) {
                hashMap.put(a,hashMap.get(a)+1);
            }
            else {
                hashMap.put(a,1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(hashMap.get(b), hashMap.get(a));
            }
        });
        Iterator<Integer> it = arrayList.iterator();

        while(it.hasNext()) {
            Integer e = it.next();
            for(int i = 0; i < hashMap.get(e);i++) {
                sb.append(e).append(" ");
            }
        }
        System.out.println(sb);
    }
}

