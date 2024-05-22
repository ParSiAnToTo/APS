import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int gap1 = Math.abs(o1-n);
            int gap2 = Math.abs(o2-n);
            
            if(gap1 < gap2){
                return -1;
            } else if (gap1 > gap2){
                return 1;
            } else {
                return Integer.compare(o2, o1);
            }
        });
        
        for(int i : numlist){
            pq.add(i);
        }        
        
        int[] answer = new int[numlist.length];
        int index = 0;
        while(!pq.isEmpty()){
            answer[index++]=pq.poll();
        }       
        
        return answer;
    }
}