import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] line = my_string.toLowerCase().split("");
        Arrays.sort(line);
        for(int i = 0; i < line.length; i++){
            answer = answer.concat(line[i]);
        }
        
        return answer;
    }
}