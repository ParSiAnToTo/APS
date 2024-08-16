import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken()) - 1;
        int S = Integer.parseInt(st.nextToken()) - 1;
        int M = Integer.parseInt(st.nextToken()) - 1;
        int year = 0;
        while (true) {
            if (year % 15 == E && year % 28 == S && year % 19 == M) {
                break;
            }
            year++;
        }

        sb.append(year + 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class