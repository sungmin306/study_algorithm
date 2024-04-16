
import java.util.*;
import java.io.*;
public class Main {

    public static int t;
    public static ArrayList<Deque<Integer>> arrayList = new ArrayList<>();
    public static int k;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < 8; j++) {
                deque.add(s.charAt(j) - '0');
            }
            arrayList.add(deque);
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            num = num -1;
            int newNum = num;
            int newDir = dir;

            int lpe =findElement(arrayList.get(newNum), 6); // leftPresentElement
            int rpe = findElement(arrayList.get(newNum), 2); // rightPresentElement
            rotation(num, dir); // 현재 톱니바퀴 방향 전환
            //print();
            while(true) { // 현재톱니바퀴 기준으로 왼쪽 계속 돌리기
                boolean b = false;
                if(newNum - 1 >= 0) { // 왼쪽에 톱니바퀴 존재
                    if(lpe != findElement(arrayList.get(newNum - 1),2)) { // 극이 달라서 돌아감
                        newDir = -1 * newDir;
                        lpe = findElement(arrayList.get(newNum - 1),6); // 돌아가기전 현재 lpe 저장
                        rotation(newNum -1, newDir);
                        //print();
                        b = true;
                    }
                }
                if(!b) break; // 반복문 그만 즉 돌릴만큼 돌리면 이제 그만 돌리기
                newNum = newNum - 1; // 왼쪽 톱니바퀴 선택
            }
            newNum = num;
            newDir = dir;
            while(true) { //현재 톱니바퀴 기준 오른쪽 계속 돌리기
                boolean b = false;
                if(newNum + 1 < t) { // 오른쪽에 톱니바퀴 존재
                    if(rpe != findElement(arrayList.get(newNum + 1),6)) { // 극이 달라서 돌아감
                        newDir = -1 * newDir;
                        rpe = findElement(arrayList.get(newNum + 1), 2);// 돌아가기전 rpe 저장
                        rotation(newNum + 1, newDir);
                        //print();
                        b = true;
                    }
                }
                if(!b) break; // 반복문 그만 즉 돌린만큼 돌리기
                newNum = newNum + 1; // 오른쪽 톱니바퀴 선택
            }
        }
        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).pollFirst() == 1) result++;
        }
        System.out.println(result);
    }
    public static void rotation(int num, int dir) {
        Deque<Integer> deque = arrayList.get(num);
        if(dir == 1) {
            deque.addFirst(deque.pollLast());
        }
        else {
            deque.addLast(deque.pollFirst());
        }


    }
    public static Integer findElement(Deque<Integer> dq, int index) {
        int cnt = 0;
        for(Integer e : dq) {
            if(cnt == index) {
                //System.out.println("e " + e);
                return e;
            }
            cnt++;
        }
        return 0;
    }

    public static void print() {
        for(int i = 0; i < arrayList.size(); i++) {
            for(Integer e : arrayList.get(i)) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }


}

/*
* Num번째 톱니바퀴 방향전환 기능 (Deque로 앞 뒤를 빼는것을 활용해서 순서를 바꿀 수 있다.)
* 방향전환 후 양 옆 톱니바퀴 확인
* 오른쪽 톱니바퀴를 확인할때 6번째 인덱스 숫자 확인
* 왼쪽 톱니바퀴를 확인할ㄸ 2번째 인덱스 숫자 확인
* 다르면 각각 다른 방향으로 회전
* 또 그 옆 톱니바퀴 확인 반복 -> 함수를 통해서 재귀함수를 만들면 될꺼같음 -> 재귀함수로하면 복귀주소로 인해 순서가 변형돼서 안될꺼같다.(?)
 */