import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[201];
        for(int i = 0; i < lines.length; i++){
            for(int j = 0; j < lines[i][1] - lines[i][0]; j++){                
                line[lines[i][0]+100+j]++;
            }
        }        
        int answer = 0;
        for(int i = 0; i < line.length; i++){
            if(line[i]>1){
                answer++;
            }
        } 
        return answer;
    }
}