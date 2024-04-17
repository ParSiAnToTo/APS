class Solution {
    public int solution(String s) {
        String[] line = s.split(" ");
        int answer = 0;
        for(int i = 0; i < line.length-1; i++){
            if(!line[i].equals("Z") && !line[i+1].equals("Z")){
                answer+=Integer.parseInt(line[i]);
            }
        }
        if(!line[line.length-1].equals("Z")){
            answer+=Integer.parseInt(line[line.length-1]);
        }
        return answer;
    }
}