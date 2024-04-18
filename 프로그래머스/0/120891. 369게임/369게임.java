import java.lang.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        String line = String.valueOf(order);
        int size = String.valueOf(order).length();
        for(int i = 0; i < size; i++){            
            int nums = line.charAt(i)-'0';
            if(nums!=0 && nums%3==0){
                answer++;
            }
        }
        return answer;
    }
}