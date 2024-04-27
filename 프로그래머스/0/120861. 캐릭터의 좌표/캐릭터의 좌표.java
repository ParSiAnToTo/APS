class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int xLimit = board[0]/2;
        int yLimit = board[1]/2;
        for(int i = 0; i < keyinput.length; i++){
            if(keyinput[i].equals("left")){
                if(Math.abs(answer[0]-1) <= xLimit){
                    answer[0]--;
                }
            }else if(keyinput[i].equals("right")){
                if(Math.abs(answer[0]+1) <= xLimit){
                    answer[0]++;
                }                
            }else if(keyinput[i].equals("up")){
                if(Math.abs(answer[1]+1) <= yLimit){
                    answer[1]++;
                }                
            }else if(keyinput[i].equals("down")){
                if(Math.abs(answer[1]-1) <= yLimit){
                    answer[1]--;
                }                
            }
        }
        return answer;
    }
}