class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int temp = 0;
        
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) -'0' >=0 && my_string.charAt(i) -'0' <= 9){
                if(temp > 0){
                    temp = temp * 10 + (my_string.charAt(i) -'0');
                } else {
                    temp = my_string.charAt(i) -'0';
                }
            } else {
                answer += temp;
                temp = 0;
            }
        }
        answer += temp;
        return answer;
    }
}