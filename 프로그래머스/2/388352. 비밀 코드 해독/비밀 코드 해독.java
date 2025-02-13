import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        comb(new ArrayList<>(), 1, n, list);       
        
        int answer = 0;
        for (ArrayList<Integer> subList : list) {
            boolean chk = true;
            for (int i = 0; i < q.length; i++) {
                int count = 0;
                for (int num : q[i]) {
                    if (subList.contains(num)) {
                        count++;
                    }
                }
                if (count != ans[i]) {
                    chk = false;
                    break;
                }
            }
            if (chk) {
                answer++;
            }
        }    
        
        return answer;
    }
    
    static public void comb(ArrayList<Integer> cur, int start, int len, ArrayList<ArrayList<Integer>> list){
        if (cur.size() == 5) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= len; i++) {
            cur.add(i);
            comb(cur, i + 1, len, list);
            cur.remove(cur.size() - 1);
        }
    }
}