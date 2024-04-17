import java.util.*;

class Solution {
    public int[] solution(int n) {
        int target = n;
        int count = 0;
        int[] list = new int[target+1];
        int i = 2;
        while(i<=target){
             if(target%i==0 && list[i]==0){
                list[i]++;
                 count++;
                 while(target%i==0){
                     target = target/i;
                 }
             }
            i++;
            
        }

        int[] answer = new int[count];
        int index = 0;
        for(int j = 2; j < n+1; j++){
            if(list[j]>0){
                answer[index]=j;
                index++;
            }
        }
        return answer;
    }
}