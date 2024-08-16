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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        int[] sizeList = new int[6];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sizeList.length; i++) {
            sizeList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < sizeList.length; i++) {
            count += sizeList[i] % T != 0 ? (sizeList[i] / T) + 1 : sizeList[i] / T;
        }
        sb.append(count).append("\n").append(N / P).append(" ").append(N % P);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class