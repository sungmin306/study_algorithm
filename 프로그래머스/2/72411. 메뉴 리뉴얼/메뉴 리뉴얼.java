import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] sortedOrders = new String[orders.length];
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            sortedOrders[i] = new String(arr);
        }

        List<String> answer = new ArrayList<>();

        for (int i : course) {
            Map<String, Integer> countMap = new HashMap<>();
            int max = 0;


            for (String j : sortedOrders) {
                String order = j; 
                if (order.length() < i) continue;

                StringBuilder sb = new StringBuilder();
                backtraking(order, i, 0, 0, sb, countMap);
            }

            for (int j : countMap.values()) {
                if (j > max) max = j;
            }
            if (max < 2) continue;

            for (Map.Entry<String, Integer> e : countMap.entrySet()) {
                if (e.getValue() == max) {
                    answer.add(e.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void backtraking(String orkder, int i, int index, int pick,
                             StringBuilder sb, Map<String, Integer> countMap) {
        if (pick == i) {
            String comb = sb.toString();
            countMap.put(comb, countMap.getOrDefault(comb, 0) + 1);
            return;
        }
        if (index >= orkder.length()) return;

        if ((orkder.length() - index) + pick < i) return;

        sb.append(orkder.charAt(index));
        backtraking(orkder, i, index + 1, pick + 1, sb, countMap);
        sb.deleteCharAt(sb.length() - 1);

        backtraking(orkder, i, index + 1, pick, sb, countMap);
    }
}
