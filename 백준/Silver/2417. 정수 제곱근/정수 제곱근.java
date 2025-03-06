import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        long right = n;
        long left = 0;
        long answer = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            if(n <= Math.pow(mid, 2)){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}