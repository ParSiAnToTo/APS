import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String answer = N % 2 == 0 ? "CY" : "SK";

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}