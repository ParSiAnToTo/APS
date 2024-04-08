class Solution {
    public String solution(String my_string, int n) {
        char[] target = my_string.toCharArray();
        String answer = "";
        for(int i = 0; i < target.length; i++){
            for(int j = 0; j < n; j++){
                answer = answer.concat(String.valueOf(target[i]));
            }
        }        
        return answer;
    }
}