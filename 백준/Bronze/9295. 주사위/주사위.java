import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int firstDice = Integer.parseInt(st.nextToken());
            int secondDice = Integer.parseInt(st.nextToken());
            int sum = firstDice + secondDice;
            result.append("Case ").append(i).append(": ").append(sum).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}