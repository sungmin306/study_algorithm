import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hashMap = new HashMap<>();
        String answer = "";
        for(int i = 0; i < participant.length; i++) {
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i],0) + 1);
        }
        
        for(int i = 0; i < completion.length; i++) {
            hashMap.put(completion[i], hashMap.get(completion[i]) - 1);
        }
        
        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) > 0) {
                return name;
            }
        }
        return answer;
    }
}