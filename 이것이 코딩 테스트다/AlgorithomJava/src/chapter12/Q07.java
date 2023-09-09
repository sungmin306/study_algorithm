package chapter12;

import java.util.*;

//내가 푼 풀이
public class Q07 {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = n;
        int cnt = 1;
        while(true) {
            int q = m/10;
            m = q;
//            System.out.println(q);
            if(q == 0) {
                break;
            }
            else cnt ++;
        }
        int a = n/(int)Math.pow(10,(cnt/2));
        int sum0 = 0;
        while(true) {
            sum0 += a % 10;
            a = a / 10;
            if(a == 0) break;
        }
        int b = n%(int)Math.pow(10,(cnt/2));
        int sum1 = 0;
        while(true) {
            sum1 =sum1 + b % 10;
            b = b / 10;
            if(b == 0) break;
        }
        if(sum0 == sum1) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}

// 교재 풀이
//public class Q07 {
//    public static String str;
//    public static int summary = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        str = sc.next();
//
//        for(int i = 0; i < str.length() / 2; i ++) {
//            summary += str.charAt(i) - '0'; // 뒤에 -'0' 를하는 이유는 그래야 문자열에서 숫자로 바꿀 수 있음
//        }
//        for (int i = str.length()/2 ; i < str.length(); i++) {
//            summary -= str.charAt(i) - '0';
//        }
//        if (summary == 0) System.out.println("LUCKY");
//        else System.out.println("READY");
//    }
//}
