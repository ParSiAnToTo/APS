class Solution {
    public int[] solution(String my_string) {
        String[] line = my_string.replaceAll("[abcdefghijklmnopqrstuvwxyz]", "").split("");
        int[] answer = new int[line.length];
        for(int i = 0; i < line.length; i++){
            answer[i] = Integer.parseInt(line[i]);
        }
        
        for(int i = 0; i < answer.length-1; i++){
            for(int j = 0; j < answer.length-1-i; j++){
                if(answer[j] > answer[j+1]){
                    int temp = answer[j];
                    answer[j]=answer[j+1];
                    answer[j+1]=temp;
                }
            }
        }
        
        return answer;
    }
}