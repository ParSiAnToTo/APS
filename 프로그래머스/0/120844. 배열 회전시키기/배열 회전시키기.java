class Solution {
    public int[] solution(int[] numbers, String direction) {        
        int[] answer = new int[numbers.length];
        if(direction.equals("right")){
            int next;
            int now = numbers[0];
            for(int i = 0; i < numbers.length-1; i++){
                next = numbers[i+1];
                numbers[i+1]=now;
                now = next;
            }
            numbers[0]=now;
        } else {
            int next;
            int now = numbers[numbers.length-1];
            for(int i = numbers.length-1; i > 0; i--){
                next = numbers[i-1];
                numbers[i-1]=now;
                now = next;
            }
            numbers[numbers.length-1]=now;            
        }
        
        for(int i = 0; i < answer.length; i++){
            answer[i]=numbers[i];
        }
        
        return answer;
    }
}