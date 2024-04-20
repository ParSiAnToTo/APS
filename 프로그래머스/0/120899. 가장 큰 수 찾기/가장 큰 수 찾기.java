class Solution {
    public int[] solution(int[] array) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
                index = i;
            }            
        }
        int[] answer = new int[2];
        answer[0]=max;
        answer[1]=index;
        return answer;
    }
}