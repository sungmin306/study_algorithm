import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int ans;
    public static int[][] S;
    public static boolean[] checkTeam;
    public static ArrayList<Integer> teamTrue;
    public static ArrayList<Integer> teamFalse;


    public static int checkScore(ArrayList<Integer> team) {
        int score = 0;
        for(int i = 0; i < team.size(); i++) {
            for(int j = i + 1; j < team.size(); j++) {
                score += S[team.get(i)][team.get(j)] + S[team.get(j)][team.get(i)];
            }
        }
        return score;
    }

    public static void classifyTeam() {
        teamTrue = new ArrayList<>();
        teamFalse = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if (checkTeam[i]) teamTrue.add(i);
            else teamFalse.add(i);
        }
    }

    public static void dfs(int idx, int d) {
        if(1 < d && d <= N-2) {
            classifyTeam();
            int teamTrueScore = checkScore(teamTrue);
            int teamFalseScore = checkScore(teamFalse);
            int diff = Math.abs(teamTrueScore-teamFalseScore);
            ans = Math.min(ans,diff);
        }
        for(int i = idx + 1; i < N; i++) {
            checkTeam[i] = true;
            dfs(i,d + 1);
            checkTeam[i] = false;
        }
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
        checkTeam = new boolean[N];
        checkTeam[0] = true;
        dfs(0,1);
        System.out.println(ans);
    }
}
