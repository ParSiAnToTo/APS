import java.util.*;

class Solution {
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        int denom = b / gcd;
        while(denom % 2 == 0) {
            denom = denom / 2;
        }
        while(denom % 5 == 0) {
            denom = denom / 5;
        }        
        int answer = 1;
        if(denom != 1){
            answer = 2;
        }
        return answer;
    }
}