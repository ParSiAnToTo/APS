class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int len = str1.length();
        if(len > str1.replace(str2, "").length()){
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
}