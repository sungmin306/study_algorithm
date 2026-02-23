import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static boolean[] team;
    public static int[][] S;
    public static int ans = Integer.MAX_VALUE;

    public static void dfs(int idx, int d) {
        if(d == N/2) {
            int[] teamA = new int[N/2]; // True Team
            int[] teamB = new int[N/2]; // False Team
            int ScoreA = 0;
            int ScoreB = 0;
            int idxA = 0;
            int idxB = 0;
            for(int i = 0; i < N; i++) {
                if(team[i]) {
                    teamA[idxA] = i;
                    idxA++;
                }
                else {
                    teamB[idxB] = i;
                    idxB++;
                }
            }
            for(int i = 0; i < N/2; i++) {
                for(int j = 0; j < N/2; j++) {
                    if(i == j) continue;
                    ScoreA += S[teamA[i]][teamA[j]];
                    ScoreB += S[teamB[i]][teamB[j]];
                }
            }
            ans = Math.min(ans, Math.abs(ScoreA-ScoreB));
        }
        if(idx >= N) return;

        // 팀으로 선택한다.
        team[idx] = true;
        dfs(idx + 1, d + 1);
        team[idx] = false;
        // 팀으로 선택 안한다.
        dfs(idx + 1, d);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        team = new boolean[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) S[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0);
        System.out.println(ans);
    }
}
