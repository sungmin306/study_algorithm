package baekjoon.direct.b4949;

import java.io.*;
import java.util.*;
public class B4949 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while(true) {
            s = br.readLine();
            String result = f(s);
            if(s.equals(".")) break;
            sb.append(result + "\n");

        }
        System.out.println(sb);
    }

    public static String f(String s) {
        Stack<Character>stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c =='[') stack.push(c);
            else if(c == ')') {
                if(stack.empty() || stack.peek() != '(') return "no";
                else stack.pop();
            }
            else if(c == ']') {
                if(stack.empty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }
        if(stack.empty()) return "yes";
        else return "no";
    }

}
