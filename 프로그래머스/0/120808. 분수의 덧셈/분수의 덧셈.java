class Solution {
    
    static public int GCD(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a=temp;
        }
        return a;
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int a1 = numer1 * denom2;
        int a2 = denom1 * denom2;
        int b1 = numer2 * denom1;
        int b2 = denom2 * denom1;
        int c1 = a1+b1;
        int c2 = a2;
        
        int gcd = GCD(c1, c2);
        
        int[] answer = {c1/gcd, c2/gcd};
        return answer;
    }
}