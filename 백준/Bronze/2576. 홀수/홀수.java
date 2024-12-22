import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int minOdd = Integer.MAX_VALUE;
        int sumOdd = 0;

        for (int i = 0; i < 7; i++) {
            if (arr[i] % 2 == 1) {
                sumOdd += arr[i];
                minOdd = Math.min(minOdd, arr[i]);
            }
        }

        if (sumOdd != 0) {
            bw.write(String.valueOf(sumOdd));
            bw.newLine();
            bw.write(String.valueOf(minOdd));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();
    }
}
