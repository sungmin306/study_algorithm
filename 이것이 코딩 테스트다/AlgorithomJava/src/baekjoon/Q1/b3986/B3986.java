package baekjoon.Q1.b3986;

import java.io.*;
import java.util.*;

public class B3986 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            stack.push(c[0]);
            for (int j = 1; j < c.length; j++) {
                if(stack.isEmpty()){
                    stack.push(c[j]);
                    continue;
                }
                if (stack.peek() == c[j])
                    stack.pop();
                else
                    stack.push(c[j]);
            }
            if (stack.isEmpty()) result++;
        }
        System.out.println(result);
    }
}

