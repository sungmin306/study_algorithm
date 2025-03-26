import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static E[] Eg;
    static E temp; // 전역 temp 객체
    static int[] P;  // disjoint set 부모 배열 (최대 200000번 인덱스까지)
    static int[] an; // 선택된 간선 번호를 저장할 배열

    static class E implements Comparable<E> {
        int p, q, w, i;
        E(int p, int q, int w, int i) {
            this.p = p;
            this.q = q;
            this.w = w;
            this.i = i;
        }
        @Override
        public int compareTo(E other) {
            return this.w - other.w;
        }
    }

    // Find 함수 (경로 압축)
    static int find(int p) {
        if (P[p] != p) {
            P[p] = find(P[p]);
        }
        return P[p];
    }

    // Merge 함수 (단순 비교 방식)
    static void merge(int p, int q) {
        if (P[p] > P[q])
            P[p] = q;
        else
            P[q] = p;
    }

    // Init 함수: 입력을 받고 간선 배열을 정렬함
    static void init(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 간선 수에 맞게 배열 생성
        Eg = new E[m];
        // P와 an 배열은 문제에서 최대 200000까지 사용한다고 가정
        P = new int[200001];
        an = new int[200001];

        // 간선 입력 (p, q, w) 그리고 간선 번호는 1부터
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Eg[i] = new E(p, q, w, i + 1);
        }
        // 정렬 (오름차순)
        Arrays.sort(Eg);
    }

    // Solve 함수: o가 0이면 최소 스패닝 트리를 구하고, o가 1이면 대체 해(즉, MMST 후보)를 구함.
    static void solve(int o) {
        // n-1 == m 인 경우에는 스패닝 트리가 유일하게 결정되어 MMST가 존재할 수 없으므로 "NO"를 출력
        if (n - 1 == m) {
            System.out.println("NO");
            System.exit(0);
        }
        // P 배열 초기화 : iota(P, P + 200001, 0)
        for (int i = 0; i < 200001; i++) {
            P[i] = i;
        }
        int j = 0; // 선택된 간선들을 저장할 인덱스
        if (o != 0) {
            // o가 1인 경우, 이전에 기록된 temp 간선의 번호를 먼저 기록하고 그 간선에 대해 union 처리
            an[0] = temp.i;
            merge(temp.p, temp.q);
        }
        // 모든 간선에 대해
        for (int i = 0; i < m; i++) {
            int x = find(Eg[i].p);
            int y = find(Eg[i].q);
            if (x != y) { // 두 정점이 다른 집합이면 연결
                merge(x, y);
                if (o != 0) {
                    j++;
                    an[j] = Eg[i].i;
                }
            } else {
                // 이미 연결되어 있어서 사이클을 형성하는 간선이면 temp에 기록
                temp = Eg[i];
            }
        }
        // o가 1이면 결과 출력
        if (o != 0) {
            System.out.println("YES");
            // C++ 코드에서는 n-1개의 간선을 출력함 (an[0]부터 an[n-2])
            for (int k = 0; k < n - 1; k++) {
                System.out.print(an[k] + " ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        solve(0);
        solve(1);
    }
}
