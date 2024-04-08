class Solution {
    public String solution(String my_string) {
        String answer = "";
        int len = my_string.length();
        
        for(int i = 0; i < len; i++){
            answer = answer.concat(String.valueOf(my_string.charAt(len-1-i)));
        }
        return answer;
    }
}