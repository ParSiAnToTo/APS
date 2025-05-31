import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        long sumA = A.chars().map(c -> c - '0').asLongStream().sum();
        long sumB = B.chars().map(c -> c - '0').asLongStream().sum();

        bw.write(String.valueOf(sumA * sumB));
        bw.flush();
        bw.close();
    }
}