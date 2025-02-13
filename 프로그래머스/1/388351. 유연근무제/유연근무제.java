class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {           
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            int count = 0;
            
            for(int j = 0; j < 7; j++){                
                if((startday+j)%7 == 6 || (startday+j)%7 == 0){
                    continue;
                }
                
                int setMin = (schedules[i]/100)*60 + schedules[i]%100 + 10;
                int logMin = (timelogs[i][j]/100)*60 + timelogs[i][j]%100;
                
                if(logMin <= setMin) {
                    count++;
                }
            }
            
            answer += count == 5 ? 1 : 0;            
        }        
        
        return answer;
    }
}