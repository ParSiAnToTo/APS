class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long pnum = Long.parseLong(p);
        for(int i = 0; i < t.length()+1 - p.length(); i++){
            Long tnum = Long.parseLong(t.substring(i, i+p.length()));
            if(pnum >= tnum){
                answer++;
            }
        }
        return answer;
    }
}