import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        if (N >= 4) {
            for (int i = 4; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
            }
        }

        bw.write(Integer.toString(arr[N]));
        bw.flush();
        bw.close();
    }

}