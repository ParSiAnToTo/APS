import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i]%n==0){
                list.add(numlist[i]);
            }
        }        
        int[] answer = new int[list.size()];
        int index = 0;
        for(int a : list){
            answer[index++]=a;
        }
        return answer;
    }
}