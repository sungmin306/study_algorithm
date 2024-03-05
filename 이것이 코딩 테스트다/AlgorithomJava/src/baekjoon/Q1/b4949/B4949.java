package baekjoon.Q1.b4949;

import java.util.*;
import java.io.*;


public class B4949 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '['){
                    stack.push(s.charAt(i));
                }
                else if(s.charAt(i) == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        stack.push(s.charAt(i));
                        break;
                    }
                    else if(stack.peek() == '(') stack.pop();
                }
                else if(s.charAt(i) == ']') { {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        stack.push(s.charAt(i));
                        break;
                    }
                }
                    if(stack.peek() == '[') stack.pop();
                }
            }
            if(stack.isEmpty()) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);

    }
}
