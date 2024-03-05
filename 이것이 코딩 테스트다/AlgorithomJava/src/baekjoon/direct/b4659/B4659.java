package baekjoon.direct.b4659;

import java.io.*;

public class B4659 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = {'a','e','i','o','u'};
        boolean check1, check2, check3;
        while(true) {
            String s = br.readLine();
            check1 = false;
            if (s.equals("end")) {
                break;
            }
            for(int i = 0; i < s.length(); i++) {
                for(int j = 0; j < 5; j++) {
                    if (s.charAt(i) == arr[j]) {
                        check1 = true;
                        break;
                    }
                }
            }
            int cntM = 0;
            int cntJ = 0;
            check2 = true;
            for(int i = 0; i < s.length(); i++) {
                boolean checkM = false;
                for(int j = 0; j < 5; j++) {
                    if (s.charAt(i) == arr[j]) {
                        checkM = true;
                    }
                }
                if(checkM) {
                    cntM++;
                    cntJ = 0;
                }
                else{
                    cntM = 0;
                    cntJ++;
                }
                if(cntM >= 3 || cntJ >= 3) {
                    check2 = false;
                }
            }
            char a = s.charAt(0);
            check3 = true;
            for(int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == 'e' || s.charAt(i) == 'o') {
                    continue;
                }
                if (a == s.charAt(i)) {
                    check3 = false;
                    break;
                }
                a = s.charAt(i);
            }
            if (check1 && check2 && check3) {
                System.out.println("<" + s + ">" + " is acceptable.");
            }
            else {
                System.out.println("<" + s + ">" + " is not acceptable.");
            }
        }

    }
}
