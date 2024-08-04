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


        int[] lenArray = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            int maxIndex = 0;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            lenArray[0] = a;
            lenArray[1] = b;
            lenArray[2] = c;
            for (int i = 0; i < 3; i++) {
                if (max < lenArray[i]) {
                    max = lenArray[i];
                    maxIndex = i;
                }
            }
            int longLen = lenArray[maxIndex] * lenArray[maxIndex];
            int plus = 0;
            for (int i = 0; i < 3; i++) {
                if (i != maxIndex) {
                    plus += lenArray[i] * lenArray[i];
                }
            }
            if (plus == longLen) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class