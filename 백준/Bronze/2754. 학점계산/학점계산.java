import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> score = new HashMap<>();
        score.put("A+", "4.3");
        score.put("A0", "4.0");
        score.put("A-", "3.7");

        score.put("B+", "3.3");
        score.put("B0", "3.0");
        score.put("B-", "2.7");

        score.put("C+", "2.3");
        score.put("C0", "2.0");
        score.put("C-", "1.7");

        score.put("D+", "1.3");
        score.put("D0", "1.0");
        score.put("D-", "0.7");

        score.put("F", "0.0");

        String point = br.readLine();
        if (score.containsKey(point)){
            sb.append(score.get(point));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}