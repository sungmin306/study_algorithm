

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                queue.add(value);
            }
            else if(command.equals("pop")) {
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.poll());
            }
            else if(command.equals("size")) System.out.println(queue.size());
            else if(command.equals("empty")) {
                if(queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(command.equals("front")) {
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());
            }
            else if(command.equals("back")) {
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.getLast());
            }
        }



    }
}
