class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i = 0 ; i < array.length; i++){
            for(int j = 0; j < String.valueOf(array[i]).length(); j++){
                if( (String.valueOf(array[i]).charAt(j)-'0')==7){
                    answer++;
                }
            }
        }
        return answer;
    }
}