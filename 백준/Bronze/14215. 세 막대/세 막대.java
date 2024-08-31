import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);

        array[2] = array[2] >= array[1] + array[0] ? array[1] + array[0] -1 : array[2];

        int answer = Arrays.stream(array).sum();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class