import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    static Map<String, Integer> map = new HashMap<>();
    static int size;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        while(true){
            String s = br.readLine();
            if(s==null || s.length()==0){
                break;
            }
            size++;
            map.put(s,map.getOrDefault(s,0)+1);
        }
        solve();
        System.out.println(sb.toString());
    }
 
    private static void solve() {
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        for(int i=0; i<keys.length; i++){
            String key = (String) keys[i];
            int treeSize = map.get(key);
            double per = (double)(treeSize*100)/size;
            sb.append(key +" "+String.format("%.4f",per)).append("\n");
        }
    }
}