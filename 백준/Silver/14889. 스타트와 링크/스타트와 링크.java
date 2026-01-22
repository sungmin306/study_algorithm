import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] S;
    public static int ans;
    public static ArrayList<Integer> teamA;
    public static ArrayList<Integer> teamB;
    public static boolean[] check;

    public static void dfs(int p, int d) {
        if(p == N) return;
        if(d == N/2) {
            int scoreA = 0;
            int scoreB = 0;
            teamB.clear();
            for(int i = 0; i <N; i++) {
                if(!check[i]) {
                    teamB.add(i);
                }
            }
            for(int i = 0; i < N/2; i++) {
                for(int j = i + 1; j < N/2; j++) {
                    scoreA += S[teamA.get(i)][teamA.get(j)] + S[teamA.get(j)][teamA.get(i)];
                    scoreB += S[teamB.get(i)][teamB.get(j)] + S[teamB.get(j)][teamB.get(i)];
                }
            }

            ans = Math.min(ans, Math.abs(scoreA-scoreB));
            return;
        }
        teamA.add(p);
        check[p] = true;
        dfs(p + 1, d + 1);
        teamA.remove(teamA.size() - 1);
        check[p] = false;
        dfs(p + 1, d);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        check = new boolean[N];
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();
        dfs(0,0);


        System.out.println(ans);


    }
}
