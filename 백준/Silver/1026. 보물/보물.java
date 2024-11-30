import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] frequency = new int[101];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            frequency[Integer.parseInt(st.nextToken())]++;
        }

        Arrays.sort(A);

        int answer = 0;
        int index = 0;
        for (int i = frequency.length - 1; i >= 0; i--) {
            while (frequency[i] != 0) {
                answer += A[index++] * i;
                frequency[i]--;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
