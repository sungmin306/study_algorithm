package baekjoon.direct.b1620;

import java.util.*;
import java.io.*;

public class B1620 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            hashMap1.put(i+1,s);
            hashMap2.put(s,i+1);
        }

        for(int i = 0; i < m; i++) {
            String s2 = br.readLine();
            if (49 <= s2.charAt(0) && s2.charAt(0) <= 57) { // 아스키 표 정수이면
                sb.append(hashMap1.get(Integer.parseInt(s2))).append("\n");
            }
            else{
                sb.append(hashMap2.get(s2)).append("\n");
            }
        }
        System.out.println(sb);

    }




}


/*
public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            arrayList.add(s);
        }

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if (checkIsDigit(s)) {
                System.out.println(arrayList.get(Integer.parseInt(s) - 1));
            }
            else{
                System.out.println(printIndex(arrayList, s));
            }
        }
    }

    public static boolean checkIsDigit(String s) {
        for(int i = 0; i < s.length();i++) {
            if(!Character.isLetter(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static int printIndex(ArrayList arrayList, String s) {
        for(int i = 0; i < arrayList.size(); i++) {
            if(s.equals(arrayList.get(i))) {
                return i + 1;
            }
        }
        return -1;
    }
 */
