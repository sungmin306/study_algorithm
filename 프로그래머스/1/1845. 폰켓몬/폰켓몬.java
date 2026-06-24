import java.util.*;
class Solution {
    public int solution(int[] nums) {
        //int answer = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(hm.get(nums[i]),0) + 1);
        }
        if(hm.size() > nums.length / 2) {
            return nums.length / 2;
        }
        return hm.size();
    }
}