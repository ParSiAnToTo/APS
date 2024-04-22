class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String[] line = String.valueOf(num).split("");
        String nums = String.valueOf(k);
        for(int i = 0 ; i < line.length; i++){
            if(line[i].equals(nums)){
                answer = i+1;
                break;
            }
        }
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}