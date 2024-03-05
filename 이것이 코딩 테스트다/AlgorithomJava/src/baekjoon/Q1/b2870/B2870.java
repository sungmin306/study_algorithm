package baekjoon.Q1.b2870;

import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class B2870 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> arrayList = new ArrayList<>();


        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("\\D");
            for(int j = 0; j < s.length; j++) {
                if(!s[j].equals("")) arrayList.add(new BigInteger(s[j]));
            }
        }
        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }




    }

}
