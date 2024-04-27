class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String[] line = polynomial.split(" ");
        int nums = 0;
        int xnums = 0;
        for(int i = 0; i < line.length; i++){
            if(line[i].substring(line[i].length()-1).equals("x")){
                if(line[i].length()>1){
                    xnums += Integer.parseInt(line[i].substring(0,line[i].length()-1));   
                } else {
                    xnums++;
                }

            } else if (!line[i].equals("+")){
                nums += Integer.parseInt(line[i]);
            }
        }
        if(xnums > 0){
            if(xnums ==1){
                answer = answer.concat("x");
            } else {
                answer = answer.concat(String.valueOf(xnums)).concat("x");
            }
        }
        if(xnums >0 && nums >0){
            answer = answer.concat(" + ").concat(String.valueOf(nums));
        }
        if(xnums == 0 && nums >0){
            answer = answer.concat(String.valueOf(nums));
        } else if (xnums ==0 && nums ==0){
            answer = "0";
        }
        return answer;
    }
}