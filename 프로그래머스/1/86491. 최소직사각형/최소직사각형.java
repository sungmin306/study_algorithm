import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            swap(sizes[i]);
        }
        int maxX = 0;
        int maxY = 0;
        for(int i = 0; i < sizes.length; i++) {
            if(maxX < sizes[i][0]) maxX = sizes[i][0];
            if(maxY < sizes[i][1]) maxY = sizes[i][1];
        }
        answer = maxX * maxY;
        return answer;
    }
    public void swap(int[] arr) {
        if(arr[0] < arr[1]) { // 0번째에 작은거 모으기
            return;
        }
        else {
            int temp = 0;
            temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        
    }
    public void show(int[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }
}