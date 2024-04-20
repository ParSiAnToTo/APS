class Solution {
    public String solution(String s) {
        String answer = "";
        int[] spell = new int[26];
        for(int i = 0; i < s.length(); i++){
            spell[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < spell.length; i++){
            if(spell[i]==1){
                answer = answer.concat( String.valueOf((char)(97+i)));
            }
        }
        return answer;
    }
}