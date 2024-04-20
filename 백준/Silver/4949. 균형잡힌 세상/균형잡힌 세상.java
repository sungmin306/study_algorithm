import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(' || c == '[') {
                    stack.push(c);
                }
                else if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        stack.push(')');
                        break;
                    }
                }
                else if(c == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        stack.push(']');
                        break;
                    }
                }
            }
            if(stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
