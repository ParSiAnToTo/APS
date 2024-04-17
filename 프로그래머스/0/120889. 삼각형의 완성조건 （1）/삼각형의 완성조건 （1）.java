class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int[] sort = new int[3];
        for(int i = 0; i < 3; i ++){
            sort[i]=sides[i];
        }
        for(int i = 0; i < 2; i++){
            for(int j = i; j < 2-i; j++){
                if(sort[j]>sort[j+1]){
                    int temp = sort[j];
                    sort[j] = sort[j+1];
                    sort[j+1]=temp;
                }
            }
        }
        
        if(sort[0]+sort[1]>sort[2]){
            answer = 1;
        } else {
            answer = 2;
        }

        
        return answer;
    }
}