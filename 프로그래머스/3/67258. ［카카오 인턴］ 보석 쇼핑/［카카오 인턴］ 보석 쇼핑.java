import java.io.*;
import java.util.*;

class Solution {
    
    static int jewelSize;
    static int range;
    
    public int[] solution(String[] gems) {
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        jewelSize = set.size();
        
        ArrayList<int[]> rangeList = new ArrayList<>();
        
        int left = 0;
        int right = 0;
        range = gems.length;            
        
        HashMap<String, Integer> rangeJewelMap = new HashMap<>();
        while(right < range){
            rangeJewelMap.compute(gems[right], (k, v) -> v == null ? 1 : v + 1);
            right++;
            
            while(rangeJewelMap.size() == jewelSize){
                rangeList.add(new int[]{left + 1, right, right - left});
                rangeJewelMap.compute(gems[left], (k, v) -> (v == 1) ? null : v - 1);
                left++;
            }                    
        }           
            
            
        rangeList.sort((a,b) -> a[2] != b[2] ? Integer.compare(a[2], b[2]) : Integer.compare(a[0], b[0]));
        
        int[] answer = {rangeList.get(0)[0], rangeList.get(0)[1]};
        return answer;
    }
}