import java.util.*;

class Solution {
    
    public String solution(long n, String[] bans) {
        
        ArrayList<Long> bansList = new ArrayList<>();
        for(String s : bans){
            bansList.add(convertToDigit(s));
        }
        Collections.sort(bansList);
        
        long digit = n;
        
        for(long banDigit: bansList){
            if(digit >= banDigit){
                digit++;
            } else {
                break;
            }
        }
        
        String answer = convertToString(digit);
        return answer;
    }
    
    public long convertToDigit(String s){
        long value = 0;
        for(char c : s.toCharArray()){
            value = value * 26 + (c - 'a' + 1);
        }
        
        return value;
    }
    
    public String convertToString(long digit){
        StringBuilder sb = new StringBuilder();
        
        while(digit > 0){
            long mod = (digit - 1) % 26;
            sb.append((char) ('a' + mod));
            digit = (digit - 1) / 26;
        }
        
        return sb.reverse().toString();
    }   

}