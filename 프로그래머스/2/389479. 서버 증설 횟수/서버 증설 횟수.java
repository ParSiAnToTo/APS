class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;
        for(int i = 0; i < 24; i++){
            if(players[i] > server[i]*(m+1) -1){
                int addServer = players[i]/m - server[i];
                answer += addServer;
                for(int j = i; j < 24 && j < i + k; j++){
                    server[j] += addServer;
                }
            }
        }
        
        return answer;
    }
}