import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (b >= c) {
            sb.append(-1);
        } else {
            int answer = (a / (c - b)) + 1;
            sb.append(answer);
        }
     
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class