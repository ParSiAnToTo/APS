class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] memo = new int[11];
        memo[0]=1;
        for(int i = 1; i <=10; i++){
            memo[i]= memo[i-1]*i;
        }
        for(int i = 10; i >=0; i--){
            if(memo[i]<=n){
                answer = i;
                break;
            }
        }
        return answer;
    }
}