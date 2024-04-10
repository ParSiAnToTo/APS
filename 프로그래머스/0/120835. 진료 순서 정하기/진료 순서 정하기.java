class Solution {
    public int[] solution(int[] emergency) {
        int[] copy = new int[emergency.length];
        for(int i = 0; i <emergency.length; i++){
            copy[i]=emergency[i];
        }
        for(int i = 0; i < emergency.length-1; i++){
            for(int j = 0; j < emergency.length-1; j++){
                if(copy[j]<copy[j+1]){
                    int temp = copy[j];
                    copy[j]=copy[j+1];
                    copy[j+1]=temp;
                }
            }
        }       
        int[] answer = new int[emergency.length];        
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j<answer.length; j++){
                if(emergency[i]==copy[j]){
                    answer[i]=j+1;
                }
            }
        }
        return answer;
    }
}