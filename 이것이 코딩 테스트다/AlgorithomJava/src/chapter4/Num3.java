package chapter4;

import java.io.*;
import java.util.*;

public class Num3 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_back")) {
                int m = Integer.parseInt(st.nextToken());
                arrayList.add(m);
            }
            else if(s.equals("push_pop")) {
                int m = Integer.parseInt(st.nextToken());
                arrayList.remove(m);
            }
            else if(s.equals("get")) {
                int m = Integer.parseInt(st.nextToken());
                //System.out.println(m);
                System.out.println(arrayList.get(m-1));
            }
            else if(s.equals("size")) {
                System.out.println(arrayList.size());
            }
            //System.out.println(arrayList.toString());
        }
    }
}


