class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length()/n)+((my_str.length()%n==0)?0:1)];
        int index = 0;
        int len = 0;
        int width = n;
        while(index < answer.length){
            answer[index++]=my_str.substring(len,len+width);
            len +=width;        
            if(len+width > my_str.length()){
                width = my_str.length()-len;
            }
          
        }
        return answer;
    }
}