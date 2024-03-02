import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Double pointSum = 0.0;
        Double count = 0.0;
        HashMap<String, Double> map = new HashMap<String, Double>(9);
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            Double point = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(grade.equals("P")){
                continue;
            } else {
                pointSum += point*map.get(grade);
                count += point;
            }
        }
        Double result = pointSum / count;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}