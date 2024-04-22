class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[][] line = new String[quiz.length][5];
        for(int i = 0; i < quiz.length; i++){
            line[i]=quiz[i].split(" ");
        }
        for(int i = 0; i < quiz.length; i++){
            int X = Integer.parseInt(line[i][0]);
            int Y = Integer.parseInt(line[i][2]);
            int Z = Integer.parseInt(line[i][4]);
            if(line[i][1].equals("+")){
                if(X+Y == Z){
                    answer[i]="O";
                } else {
                    answer[i]="X";
                }
            } else {
                if(X-Y == Z){
                    answer[i]="O";
                } else {
                    answer[i]="X";
                }                
            }
        }
        return answer;
    }
}