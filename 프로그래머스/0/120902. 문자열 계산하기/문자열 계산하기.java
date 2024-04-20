class Solution {
    public int solution(String my_string) {
        String[] line = my_string.split(" ");
        boolean flag = false;
        int answer = 0;
        for(int i = 0; i < line.length; i++){
            if(!line[i].equals("+") && !line[i].equals("-") && !flag){
                answer += Integer.parseInt(line[i]);
            } else if (!line[i].equals("+") && !line[i].equals("-") && flag){
                answer -= Integer.parseInt(line[i]);
            } else if (line[i].equals("-")){
                flag = true;
            } else if (line[i].equals("+")){
                flag = false;
            }
        }
        return answer;
    }
}