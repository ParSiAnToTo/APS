import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int answer = Integer.parseInt(input[0]) * (Integer.parseInt(input[1]) - 1) + 1;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}