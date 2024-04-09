class Solution {
    public String solution(int age) {
        String target = String.valueOf(age);
        String answer = "";
        String[] list = {"a","b","c","d","e","f","g","h","i","j"};
        for(int i = 0; i < target.length(); i++){
            answer = answer.concat(list[target.charAt(i)-'0']);
        }
        return answer;
    }
}