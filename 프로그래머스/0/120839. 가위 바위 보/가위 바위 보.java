class Solution {
    public String solution(String rsp) {
        String answer = "";
        int[] rcpCount = {0, 5, 2};
        String[] list = rsp.split("");
        for(int i = 0; i < list.length; i++){
            if(Integer.parseInt(list[i])==2){
                answer = answer.concat(String.valueOf(rcpCount[0]));
            } else if (Integer.parseInt(list[i])==0){
                answer = answer.concat(String.valueOf(rcpCount[1]));
            } else {
                 answer = answer.concat(String.valueOf(rcpCount[2]));
            }
        }
        return answer;
    }
}