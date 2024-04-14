class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n >3){
            for(int i = 4; i <= n; i++){
                for(int j = 2; j <= Math.sqrt(i); j++){
                    if(i%j==0){
                        answer++;
                        break;
                    }
                }
           }                        
        } else {
            answer = 0;
        }       
        
        return answer;
    }
}