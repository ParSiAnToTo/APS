import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n/2; i++){
            if(n%i==0){
                list.add(i);
            }
        }
        list.add(n);
        int[] answer = new int[list.size()];
        int index = 0;
        for(int a : list){
            answer[index++]=a;
        }
        return answer;
    }
}