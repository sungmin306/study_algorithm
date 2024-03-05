package baekjoon.direct.b9012;

import java.util.*;
import java.io.*;

public class B9012 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < c.length; j++) {
                if(stack.isEmpty()){
                    stack.push(c[j]);
                    continue;
                }
                if(stack.peek() == '('){
                    if(c[j] == ')') stack.pop();
                    else stack.push(c[j]);

                }
                else {
                    stack.push(c[j]);
                }
            }
            if(stack.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

}
