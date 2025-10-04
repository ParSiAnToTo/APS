import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ISBN = br.readLine();
        int m = ISBN.charAt(12) - '0';
        int sum = 0;
        int weight = 0;
        for (int i = 0; i < ISBN.length() - 1; i++) {
            if (ISBN.charAt(i) == '*') {
                weight = (i % 2 == 0) ? 1 : 3;
            } else if (i % 2 == 0) {
                sum += ISBN.charAt(i) - '0';
            } else {
                sum += (ISBN.charAt(i) - '0') * 3;
            }
        }
        for (int i = 0; i < 10; i++) {
            if ((sum + (i * weight) + m) % 10 == 0) {
                bw.write(String.valueOf(i));
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}