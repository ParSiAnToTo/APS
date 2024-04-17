class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int gap = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            if(gap > Math.abs(n-array[i])){
                gap = Math.abs(n-array[i]);
                answer = array[i];
            } else if (gap == Math.abs(n-array[i])){
                answer = Math.min(answer, array[i]);
            }
        }
        return answer;
    }
}