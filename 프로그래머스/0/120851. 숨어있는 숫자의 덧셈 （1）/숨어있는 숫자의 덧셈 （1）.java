class Solution {
    public int solution(String my_string) {
        String[] line = my_string.replaceAll("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]", "").split("");
        int answer = 0;
        for(int i = 0; i < line.length; i++){
            answer += Integer.parseInt(line[i]);
        }
        return answer;
    }
}