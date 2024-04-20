class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] line = my_string.split("");
        String char1 = line[num1];
        String char2 = line[num2];
        line[num1]=char2;
        line[num2]=char1;
        for(int i = 0; i < line.length; i++){
            answer=answer.concat(line[i]);
        }
        return answer;
    }
}