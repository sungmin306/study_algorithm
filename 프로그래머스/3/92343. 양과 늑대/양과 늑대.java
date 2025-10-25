import java.util.*;

class Solution {
    private int[] info;
    private List<Integer>[] adj;
    private int n, answer;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.n = info.length;
        this.answer = 0;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int sheep = (info[0] == 0) ? 1 : 0;
        int wolf  = (info[0] == 1) ? 1 : 0;

        List<Integer> frontier = computeFrontier(visited); 
        dfs(visited, frontier, sheep, wolf);
        return answer;
    }

    private void dfs(Set<Integer> visited, List<Integer> frontier, int sheep, int wolf) {
        if (sheep > answer) answer = sheep;

        if (frontier.isEmpty()) return;

        Collections.sort(frontier);

        for (int i = 0; i < frontier.size(); i++) {
            int next = frontier.get(i);

            Set<Integer> newVisited = new HashSet<>(visited);
            newVisited.add(next);

            int ns = sheep + (info[next] == 0 ? 1 : 0);
            int nw = wolf  + (info[next] == 1 ? 1 : 0);

            if (ns <= nw) continue;

            List<Integer> newFrontier = computeFrontier(newVisited);

            dfs(newVisited, newFrontier, ns, nw);
        }
    }

    private List<Integer> computeFrontier(Set<Integer> visited) {
        Set<Integer> cand = new HashSet<>();
        for (int u : visited) {
            for (int v : adj[u]) {
                if (!visited.contains(v)) cand.add(v);
            }
        }
        return new ArrayList<>(cand);
    }
}
