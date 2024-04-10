import java.util.HashMap;

class Solution {
    public String solution(String letter) {
        String answer = "";
        HashMap<String, Character> morseDecode = new HashMap<>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int spell = 97;
        for(int i=0; i <morse.length; i++){
            morseDecode.put(morse[i], (char) spell++);
        }
        String[] letterList = letter.split(" ");
        for(int i = 0; i < letterList.length; i++){
            answer = answer.concat(String.valueOf(morseDecode.get(letterList[i])));
        }
 
        return answer;
    }
}