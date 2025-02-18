class Solution {
    public int solution(int n, int w, int num) {
        int[][] storage = new int[n / w + 1][w];
        int number = 1;
        int[] position = new int[2];
        
        outer: for(int i = 0; i < storage.length; i++) {
            if(i % 2 == 0){
                for(int j = 0; j < w; j++) {
                    storage[i][j] = number++;
                    if(number == num +1){
                        position[0] = i;
                        position[1] = j;
                    }
                    if(number > n){
                        break outer;
                    }
                }    
            } else {
                for(int j = w-1; j >= 0; j--) {
                    storage[i][j] = number++;
                    if(number == num +1){
                        position[0] = i;
                        position[1] = j;
                    }
                    if(number > n){
                        break outer;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = n / w; i >= position[0] ; i--){
            if(storage[i][position[1]] != 0){
                answer++;
            }
        }        

        return answer;
    }
}