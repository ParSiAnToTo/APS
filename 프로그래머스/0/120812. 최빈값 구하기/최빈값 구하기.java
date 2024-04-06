class Solution {
    public int solution(int[] array) {
        int[] count = new int[1001];
        for(int i = 0; i < array.length; i++){
            count[array[i]]++;
        }        
        int answer = 0;
        int max = 0;
        boolean flag = false;
        for(int i = 0; i < count.length; i++){
            if(max == count[i]){
                flag = true;
            }
            if(max < count[i]){
                max = count[i];
                answer = i;
                flag = false;
            } 
        }
        if (flag){
            answer = -1;
        }
        
        return answer;
    }
}