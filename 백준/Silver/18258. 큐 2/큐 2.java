

import java.util.*;
import java.io.*;


public class Main {

    static int[] q = new int[2000001];	

    static int size = 0;
    static int front = 0;
    static int back = 0;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) push(Integer.parseInt(st.nextToken()));
            else if(s.equals("pop")) pop();
            else if(s.equals("size")) size();
            else if(s.equals("empty")) empty();
            else if(s.equals("front")) front();
            else back();
        }
        System.out.println(sb);
    }

    static void push(int n) {
        q[back] = n;
        back++;
        size++;
    }

    static void pop() {
        if(size == 0) {
            sb.append(-1).append('\n');
        }
        else {
            sb.append(q[front]).append('\n');
            size--;
            front++;
        }
    }

    static void size() {
        sb.append(size).append('\n');
    }

    static void empty() {
        if(size == 0) {
            sb.append(1).append('\n');
        }
        else sb.append(0).append('\n');
    }

    static void front() {
        if(size == 0) {
            sb.append(-1).append('\n');
        }
        else {
            sb.append(q[front]).append('\n');
        }
    }

    static void back() {
        if(size == 0) {
            sb.append(-1).append('\n');
        }
        else {
            sb.append(q[back - 1]).append('\n');	
        }
    }
}
