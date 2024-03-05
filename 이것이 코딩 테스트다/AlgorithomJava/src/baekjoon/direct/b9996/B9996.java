package baekjoon.direct.b9996;

import java.util.*;
import java.io.*;

public class B9996 {

    public static ArrayList<Character> front = new ArrayList<>();
    public static ArrayList<Character> back = new ArrayList<>();
    public static int point;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        for(int i = 0; i < c.length; i++) { // * 위치 찾기
            if ((int)c[i] == 42) {
                point = i;
                break;
            }
        }
        for(int i = 0; i < point; i++) {
            front.add(c[i]);
        }
        for(int i = point+1; i < c.length; i++) {
            back.add(c[i]);
        }
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            System.out.println(check(s));
        }
    }
    public static String check(String s) {
        if (s.length() < front.size() + back.size()) {
            return "NE";
        }
        for(int i = 0; i < front.size(); i++) {
            if(front.get(i) != s.charAt(i)) {
                return "NE";
            }
        }
        for(int i = 0; i < back.size(); i++) {
            if(back.get(i) != s.charAt(s.length()-back.size()+i)) {
                return "NE";
            }
        }
        return "DA";
    }
}
