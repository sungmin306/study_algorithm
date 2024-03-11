import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] oneSol = {1,2,3,4,5};
        int[] twoSol = {2,1,2,3,2,4,2,5};
        int[] threeSol = {3,3,1,1,2,2,4,4,5,5};
        int[] people = {0,0,0};

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == oneSol[i % oneSol.length]) people[0]++;
            if(answers[i] == twoSol[i % twoSol.length]) people[1]++;
            if(answers[i] == threeSol[i % threeSol.length]) people[2]++;
        }
        int maxValue = findMax(people);
        for(int i = 0; i < 3; i++) {
            if(maxValue == people[i])  arrayList.add(i+1);
        }
        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
    public int findMax(int[] people) {
        int returnMax = Arrays.stream(people).max().getAsInt();
        return returnMax;
    }
}