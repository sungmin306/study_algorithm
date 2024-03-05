package baekjoon.direct.b3986;

import java.util.*;
import java.io.*;

public class B3986 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (!stack.isEmpty() && arr[j] == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(arr[j]);
                }
            }
            if (stack.size() == 0) {
                result++;
            }
            stack.clear();
        }
        System.out.println(result);
    }
}
