package baekjoon.direct.b2870;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B2870 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> result = new ArrayList<>();
        for(int i = 0; i <n; i++) {
            String[] s = br.readLine().split("\\D");
            for(int j = 0; j < s.length; j++) {
                if(!s[j].equals("")) result.add(new BigInteger(s[j]));
            }
        }
        Collections.sort(result);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
