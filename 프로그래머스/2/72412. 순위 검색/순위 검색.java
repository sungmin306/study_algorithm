import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> index = new HashMap<>();

        for (String s : info) {
            String[] parts = s.split(" ");
            String[] attrs = new String[] { parts[0], parts[1], parts[2], parts[3] };
            int score = Integer.parseInt(parts[4]);

            buildKeys(attrs, 0, new StringBuilder(), index, score);
        }

        for (List<Integer> list : index.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String normalized = query[i].replace(" and ", " ");
            String[] parts = normalized.split(" ");
            String key = parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3];
            int scoreMin = Integer.parseInt(parts[4]);

            List<Integer> list = index.getOrDefault(key, Collections.emptyList());
            int cnt = countGreaterEqual(list, scoreMin); 
            answer[i] = cnt;
        }

        return answer;
    }
    private void buildKeys(String[] attrs, int depth, StringBuilder sb,
                           Map<String, List<Integer>> index, int score) {
        if (depth == 4) {
            String key = sb.toString().trim();
            index.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        int prevLen = sb.length();

        if (sb.length() > 0) sb.append(' ');
        sb.append(attrs[depth]);
        buildKeys(attrs, depth + 1, sb, index, score);

        sb.setLength(prevLen);

        if (sb.length() > 0) sb.append(' ');
        sb.append('-');
        buildKeys(attrs, depth + 1, sb, index, score);

        sb.setLength(prevLen);
    }

    private int countGreaterEqual(List<Integer> list, int scoreMin) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (list.get(mid) < scoreMin) left = mid + 1;
            else right = mid;
        }
        return list.size() - left;
    }
}
