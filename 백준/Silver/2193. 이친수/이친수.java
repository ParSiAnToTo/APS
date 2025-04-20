import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N + 3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        if(N >= 3){
            for(int i = 3; i <= N; i++){
                arr[i] = arr[i-2] + arr[i-1];
            }
        }

        bw.write(Long.toString(arr[N]));
        bw.flush();
        bw.close();
    }
}