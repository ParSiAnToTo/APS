import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] line = new int[3];

        for (int i = 0; i < 3; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);

        for (int i : line){
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}