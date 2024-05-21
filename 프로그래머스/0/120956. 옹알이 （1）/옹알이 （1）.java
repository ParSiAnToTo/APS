import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        for(int i = 0; i < babbling.length; i++){
            String target = babbling[i];
            for(String s : set){
                while (target.contains(s)) {
                    target = target.replace(s, "X");
                }
            }            
            boolean chk = true;
            for(char c : target.toCharArray()){
                if(c != 'X'){
                    chk = false;
                    break;
                }
            }
            
            if(chk){
                answer++;
            }

            

            }
            
            
        
        return answer;
    }
}