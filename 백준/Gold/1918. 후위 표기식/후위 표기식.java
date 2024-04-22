
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((int)'A'<= (int)c && (int)c <= (int)'Z' ) {
                sb.append(c);
            }
            else {
                if(c == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                else if(c == '(') {
                    stack.push(c);
                }
                else {
                    while(!stack.isEmpty() && checkPriority(stack.peek()) >= checkPriority(s.charAt(i))) {
                        sb.append(stack.pop());
                    }
                    stack.push(s.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()) {
            if(stack.peek() != '(') sb.append(stack.pop());
        }
        System.out.println(sb);
    }
    public static int checkPriority(char c) {
        if(c == '+' || c == '-') return 1;
        else if(c == '*' || c == '/' ) return 2;
        return 0;
    }
    

}
