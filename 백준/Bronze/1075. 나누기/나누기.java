import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int base = (N / 100) * 100;
        for (int i = 0; i < 100; i++) {
            if ((base + i) % F == 0) {
                bw.write(String.format("%02d", i));
                break;
            }
        }

        bw.flush();
        bw.close();
    }

}