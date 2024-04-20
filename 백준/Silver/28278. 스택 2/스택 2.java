

import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if(m == 1) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(m == 2) {
                if(stack.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(stack.pop()).append("\n");
                }
            }
            else if(m == 3) {
                sb.append(stack.size()).append("\n");
            }
            else if(m == 4) {
                if(stack.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else {
                if(stack.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
