import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int result = 0;
        int nums = 0;
        for (int i =  N.length()-1; i >= 0; i--) {
            if(N.charAt(i) -'A' >= 0) {
                result += ((N.charAt(i) - 'A') + 10) * Math.pow(B, nums++);
            } else {
                result += (N.charAt(i)-'0') * Math.pow(B, nums++);
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}