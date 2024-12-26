

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                deq.add(value);
            }
            else if(command.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                deq.addFirst(value);
            }
            else if(command.equals("pop_back")) {
                if (deq.isEmpty()) System.out.println(-1);
                else System.out.println(deq.pollLast());
            }
            else if(command.equals("pop_front")) {
                if (deq.isEmpty()) System.out.println(-1);
                else System.out.println(deq.poll());
            }
            else if (command.equals("size")) {
                System.out.println(deq.size());
            }
            else if(command.equals("empty")) {
                if(deq.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(command.equals("front")) {
                if(deq.isEmpty()) System.out.println(-1);
                else System.out.println(deq.getFirst());
            }
            else if(command.equals("back")) {
                if(deq.isEmpty()) System.out.println(-1);
                else System.out.println(deq.getLast());
            }

        }
    }
}
