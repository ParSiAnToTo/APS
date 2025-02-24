import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int maxSec = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        String currentTime = pos;
        for(int i = 0; i < commands.length; i++){
            if(isOp(currentTime, op_start, op_end)){
                currentTime = op_end;
            }
            
            if(commands[i].equals("prev")){
               currentTime = move(currentTime, maxSec, false); 
            } else if (commands[i].equals("next")){
                currentTime = move(currentTime, maxSec, true);
            }
            
            if(isOp(currentTime, op_start, op_end)){
                currentTime = op_end;
            }
        }       

        String answer = currentTime;
        return answer;
    }
    
    public String move(String cur, int max, boolean moveChk){
        int sec = Integer.parseInt(cur.split(":")[0]) * 60 + Integer.parseInt(cur.split(":")[1]);
        if(moveChk){
            sec += 10;            
        } else {
            sec -= 10;
        }
        
        if(sec < 0){
            sec = 0;
        } else if (sec > max){
            sec = max;
        }
        
        int curMin = sec / 60;
        int curSec = sec % 60;
        
        String currentTime = (curMin >= 10 ? String.valueOf(curMin) : "0" + String.valueOf(curMin))
            + ":" + (curSec >= 10 ? String.valueOf(curSec) : "0" + String.valueOf(curSec));
        
        return currentTime;

    }
    
    public boolean isOp(String cur, String st, String ed){
        int sec = Integer.parseInt(cur.split(":")[0]) * 60 + Integer.parseInt(cur.split(":")[1]);
        int start = Integer.parseInt(st.split(":")[0]) * 60 + Integer.parseInt(st.split(":")[1]);
        int end = Integer.parseInt(ed.split(":")[0]) * 60 + Integer.parseInt(ed.split(":")[1]);
        
        if(sec >= start && sec <= end){
            return true;
        }       

        return false;
    }
}