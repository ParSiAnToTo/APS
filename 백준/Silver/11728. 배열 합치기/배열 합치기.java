import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 0;
        int idxB = 0;

        while (idxA < N && idxB < M) {
            if (arrA[idxA] > arrB[idxB]) {
                result.append(arrB[idxB]).append(' ');
                idxB++;
            } else {
                result.append(arrA[idxA]).append(' ');
                idxA++;
            }

            if(idxA == N){
                while(idxB < M){
                    result.append(arrB[idxB]).append(' ');
                    idxB++;
                }
            } else if(idxB == M){
                while(idxA < N){
                    result.append(arrA[idxA]).append(' ');
                    idxA++;
                }
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}