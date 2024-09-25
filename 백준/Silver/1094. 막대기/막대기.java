import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());
        int count = 0;

        while (X != 0) {
            if (X % 2 == 1) {
                count++;
            }
            X /= 2;
        }

        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class