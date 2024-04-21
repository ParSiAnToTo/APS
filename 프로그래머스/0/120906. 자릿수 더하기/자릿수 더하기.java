class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] line = String.valueOf(n).split("");
        for(int i = 0; i < line.length; i++){
            answer += Integer.parseInt(line[i]);
        }
        return answer;
    }
}