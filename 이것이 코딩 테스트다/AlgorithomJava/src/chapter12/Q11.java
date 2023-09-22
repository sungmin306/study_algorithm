package chapter12;


import java.util.*;

class Node {
    private int time;
    private char direction;

    public Node(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public char getDirection() {
        return direction;
    }
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Q11 {

    public static int n, k, l;
    public static int[][] arr = new int[101][101]; // 맵 정보
    public static ArrayList<Node> info = new ArrayList<>(); // 방향 회전 정보

    public static int turn(int direction, char c) {
        if(c == 'L') direction = (direction == 0) ? 3 : direction - 1; // 왼쪽으로 갈 경우
        else direction = (direction + 1) % 4; // 오른쪽으로 갈 경우 ( % 4 를 해서 4가 될경우 자연스럽게 0으로 감 )
        return direction;
    }

    public static int simulate() {
        int x= 1, y = 1; // 뱀 머리 위치
        arr[x][y] = 2; // 뱀이 존재하는 위치
        int direction = 0; // 처음 바라보는 방향 (동쪽)
        int time = 0; // 시간
        int index = 0; // 다음에 회전할 정보 ( 총 몇번 회전했는지)

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x,y));

        while (true) {
            int nx = x + dc[direction];
            int ny = y + dr[direction];

            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2) {
                if(arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx,ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx,ny));
                }
            }
            else {
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            if (index < l && time == info.get(index).getTime()) { // 회전할 시간인 경우 회전
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }

    public static int dc[] = {0,1,0,-1};
    public static int dr[] = {1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int c = sc.nextInt();
            int r = sc.nextInt();
            arr[c][r] = 1;
        }

        l = sc.nextInt();

        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0); // L = 왼쪽 D = 오른쪽
            info.add(new Node(x,c));
        }
        System.out.println(simulate());


    }
}
