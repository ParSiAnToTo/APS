class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = sides[0]+sides[1];
        int shortLen = Math.min(sides[0], sides[1]);
        int longLen = Math.max(sides[0], sides[1]);

        for(int i = max-1; i > 0; i--){
            if(i + shortLen <= longLen){
                break;
            }
            answer++;
        }
        return answer;
    }
}