class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        boolean xcheck = false;
        boolean ycheck = false;
        if(dot[0]<0){
            xcheck = true;
        }
        if(dot[1]<0){
            ycheck = true;
        }
        if(xcheck && ycheck){
            answer = 3;
        } else if(xcheck && !ycheck){
            answer = 2;
        } else if(!xcheck && ycheck){
            answer = 4;
        } else {
            answer = 1;
        }
        
        return answer;
    }
}