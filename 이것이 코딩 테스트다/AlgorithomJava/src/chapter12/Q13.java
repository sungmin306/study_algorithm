package chapter12;
import java.util.*;

class Combination {
    private int n;
    private int r;
    private int[] now;
    private ArrayList<ArrayList<Position1>> result;

    public ArrayList<ArrayList<Position1>> getResult(){
        return result;
    }
    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position1>>();
    }

    public void combination(ArrayList<Position1> arr, int depth, int index, int target) {
        if (depth == r ) {
            ArrayList<Position1> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr,depth + 1, index + 1, target + 1);
        combination(arr,depth,index,target + 1);
    }
}

class Position1 {
    private int x;
    private int y;

    Position1(int x, int y) {
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
public class Q13 {

    public static ArrayList<Position1> arrayList1 = new ArrayList<>(); // 집
    public static ArrayList<Position1> arrayList2 = new ArrayList<>(); // 치킨집

    public static int getSum(ArrayList<Position1> candidates) {
        int result = 0;
        for(int i = 0; i < arrayList1.size(); i++) {
            int hx = arrayList1.get(i).getX();
            int hy = arrayList1.get(i).getY();
            int temp = (int) 1e9;
            for(int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx-cx) + Math.abs(hy - cy));
            }
            result += temp;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr =new int[n][n];
        int[] a = new int[2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) arrayList1.add(new Position1(i,j));
                else if (arr[i][j] == 2 ) arrayList2.add(new Position1(i,j));
            }
        }
        //System.out.println(Arrays.deepToString(arr)); // 2차원 배열 한번에 출력

        Combination comb = new Combination(arrayList2.size(),m);
        comb.combination(arrayList2,0,0,0);
        ArrayList<ArrayList<Position1>> chickenList = comb.getResult();

        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);







    }
}
