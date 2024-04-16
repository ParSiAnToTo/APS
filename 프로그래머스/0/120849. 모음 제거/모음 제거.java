class Solution {
    public String solution(String my_string) {
        String[] list = {"a","e","i","o","u"};
        String answer = my_string;
        for(int i = 0; i < list.length; i++){
            answer = answer.replace(list[i], "");
        }
        
        return answer;
    }
}