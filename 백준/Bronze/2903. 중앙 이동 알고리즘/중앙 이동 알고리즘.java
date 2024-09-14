import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        double answer = Math.pow((Math.pow(2, N) + 1), 2);
        sb.append((long) answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class