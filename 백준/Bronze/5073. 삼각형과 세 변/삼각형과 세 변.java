import java.io.*;
import java.util.*;

public class Main {

    static boolean isValid(int a, int b, int c) {
        if (a > b && a > c) {
            return a < b + c;
        } else if (b > a && b > c) {
            return b < a + c;
        } else {
            return c < a + b;
        }
    }

    static String defineTriangle(int a, int b, int c) {
        if (a == b && a == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int a, b, c;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            if (isValid(a, b, c)) {
                String defineValue = defineTriangle(a, b, c);
                sb.append(defineValue).append("\n");
            } else {
                sb.append("Invalid").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class