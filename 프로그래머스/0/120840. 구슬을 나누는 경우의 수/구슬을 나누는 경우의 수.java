import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        int gap = Math.max(share, balls-share);
        int gapmin = Math.min(share, balls-share);
        BigInteger bi = new BigInteger("1");
        for(int i = gap+1; i<=balls; i++){
            bi = bi.multiply(new BigInteger(String.valueOf(i)));
        }
        for(int i = 1; i<=gapmin; i++){
            bi = bi.divide(new BigInteger(String.valueOf(i)));
        }
        answer = bi.intValue();
        return answer;
    }
}