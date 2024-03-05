package baekjoon.Q1.b9996;

import java.io.*;

public class B9996Ver2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] arr = pattern.split("\\*");
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if (!check(arr, s)) sb.append("NE" + "\n");
            else sb.append("DA" + "\n");
        }
        System.out.println(sb);

    }
    public static boolean check(String[] arr, String s) {
        if(arr[0].length() + arr[1].length() > s.length()) {
            return false;
        }
        String front = s.substring(0, arr[0].length());
        String back = s.substring(s.length() - arr[1].length(),s.length());

        if(!front.equals(arr[0]) && !back.equals(arr[1])) return false;
        return true;
    }

}
