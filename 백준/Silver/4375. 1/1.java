

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int b = 1;
            int count = 1;
            while ((b = b % n) != 0) {
                count++;
                b = b * 10 + 1;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
