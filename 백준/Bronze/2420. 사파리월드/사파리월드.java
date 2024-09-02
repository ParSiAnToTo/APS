import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long answer = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .reduce((N, M) -> Math.abs(N - M))
                .getAsLong();

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class