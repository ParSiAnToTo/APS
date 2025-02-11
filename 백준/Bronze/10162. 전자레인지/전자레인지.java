import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int A = T / 300;
        int B = (T % 300) / 60;
        int C = (T % 60) / 10;
        if (T % 10 != 0) {
            result.append(-1);
        } else {
            result.append(A).append(' ').append(B).append(' ').append(C);
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}