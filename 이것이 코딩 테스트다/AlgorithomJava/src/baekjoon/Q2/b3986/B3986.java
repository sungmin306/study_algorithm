package baekjoon.Q2.b3986;

import java.util.*;
import java.io.*;

public class B3986 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < s.length(); j++) {
                if(stack.empty() || stack.peek() != s.charAt(j)) {
                    stack.push(s.charAt(j));
                }
                else if(stack.peek() == s.charAt(j)) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) result++;
        }
        System.out.println(result);

    }
}
