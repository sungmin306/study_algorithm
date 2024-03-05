package baekjoon.Q1.b9996;

import java.util.*;
import java.io.*;

public class B9996 {

    public static char[] arr;
    public static int point;
    public static char[] front;
    public static char[] back;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        point = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]=='*'){
                point = i;
                break;
            }
        }
        front = new char[point];
        back = new char[arr.length - point - 1];
        for(int i = 0; i < point; i++) {
            front[i] = arr[i];
        }
        for(int i = 0; i < back.length; i++) {
            back[i] = arr[point+1+i];
        }

        for(int i = 0; i < n; i++) {
            char[] arr2 = br.readLine().toCharArray();
            System.out.println(check(arr2));
        }
    }

    public static String check(char[] arr2) {
        if(arr.length-1 > arr2.length) {
            return "NE";
        }
        for(int i = 0; i < front.length; i++) {
            if(arr2[i] != front[i]) {
                return "NE";
            }
        }
        for(int i = 0; i < back.length; i++) {
            if(arr2[arr2.length- back.length + i] != back[i]) {
                return "NE";
            }
        }
        return "DA";
    }

}
