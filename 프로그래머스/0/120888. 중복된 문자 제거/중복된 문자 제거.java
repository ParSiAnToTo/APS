import java.util.*;

class Solution {
    public String solution(String my_string) {
        HashSet<String> set = new HashSet<>();
        String[] line = my_string.split("");
        String answer = "";
        for(int i = 0; i < line.length; i++){
            if(!set.contains(line[i])){
                set.add(line[i]);
                answer = answer.concat(line[i]);
            }
        }
        return answer;
    }
}