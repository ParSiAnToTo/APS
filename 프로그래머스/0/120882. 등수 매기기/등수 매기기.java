import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] sumArray = new int[score.length];
        Integer[] indexArray = new Integer[score.length];
        for(int i = 0 ; i < sumArray.length; i++){
            sumArray[i] = score[i][0]+score[i][1];
            indexArray[i] = i;
        }
        Arrays.sort(indexArray, (a, b) -> sumArray[b] - sumArray[a]);
        int[] answer = new int[sumArray.length];
        int index = 1;
        for(int i = 0; i < answer.length; i++){
            if(i > 0 && sumArray[indexArray[i]] == sumArray[indexArray[i-1]]){
                answer[indexArray[i]] = answer[indexArray[i-1]];
            } else {
                answer[indexArray[i]] = index;
            }
            index++;
        }
        return answer;
    }
}