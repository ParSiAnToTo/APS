import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] myPockets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String answer = myPockets[0]*100 >= myPockets[1] ? "Yes" : "No";

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
