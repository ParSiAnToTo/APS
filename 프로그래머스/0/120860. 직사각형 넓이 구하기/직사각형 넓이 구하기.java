class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x1 = -256;
        int x2 = 256;
        int y1 = -256;
        int y2 = 256;
        for(int i = 0 ; i < 4; i++){
            x1 = Math.max(dots[i][0], x1);
            x2 = Math.min(dots[i][0], x2);
            y1 = Math.max(dots[i][1], y1);
            y2 = Math.min(dots[i][1], y2);
        }
        answer = Math.abs(x1-x2) * Math.abs(y1-y2);
        return answer;
    }
}