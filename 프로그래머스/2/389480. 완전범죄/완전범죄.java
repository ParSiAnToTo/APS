import java.util.*;

class Solution {
    
    static final int INF = 1000000;
    
    public int solution(int[][] info, int n, int m) {
        
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];
            
            int[] next = new int[m];
            Arrays.fill(next, INF);
            
            for (int i = 0; i < m; i++) {
                if (dp[i] == INF){
                    continue;
                }                

                int newA = dp[i] + aCost;
                if (newA < n) {
                    next[i] = Math.min(next[i], newA);
                }
                
                int newB = i + bCost;
                if (newB < m) {
                    next[newB] = Math.min(next[newB], dp[i]);
                }
            }
            dp = next;
        }
        
        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[i]);
        }
        
        return answer == INF ? -1 : answer;
    }
}
