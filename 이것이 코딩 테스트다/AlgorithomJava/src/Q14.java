import java.util.*;

class Permutation {
    private int n;
    private int r;
    private int[] now; // 현재 순열
    private ArrayList<ArrayList<Integer>> result; // 모든 순열

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permutation(int[] arr, int depth) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(now[i]);
            }
            result.add(temp);
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(arr,i,depth);
            now[depth] = arr[depth];
            permutation(arr,depth+1);
            swap(arr,i,depth);
        }
    }

}

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        // 길이 2배로 늘리기
        ArrayList<Integer> weakList = new ArrayList<>();
        for(int i = 0; i < weak.length; i++) {
            weakList.add(weak[i]);
        }
        for(int i = 0; i < weak.length; i++) {
            weakList.add(weak[i] + n);
        }

        int answer = dist.length + 1; // 최대 값으로 고정 ( 최솟값을 찾아야 하므로)
        Permutation perm = new Permutation(dist.length, dist.length);
        perm.permutation(dist,0);
        ArrayList<ArrayList<Integer>> distList = perm.getResult();
        for(int start = 0; start < weak.length; start++) {
            for (int i = 0; i < distList.size(); i++) {
                int cnt = 1;
                int position = weakList.get(start) + distList.get(i).get(cnt - 1);
                for(int index = start; index < start + weak.length; index++) {
                    if (position < weakList.get(index)) {
                        cnt += 1;
                        if (cnt > dist.length) {
                            break;
                        }
                        position = weakList.get(index) + distList.get(i).get(cnt - 1);
                    }
                }
                answer = Math.min(answer, cnt); // 최솟값 계산
            }
        }
        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }
}

public class Q14 {

    public static int n;
    public static int[] weak = {1,3,4,9,10};
    public static int[] dist = {3,5,7};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Solution so = new Solution();
        System.out.println(so.solution(n,weak,dist));
    }
}
