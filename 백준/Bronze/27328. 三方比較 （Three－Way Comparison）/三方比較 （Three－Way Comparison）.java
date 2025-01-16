import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int answer = A - B;
        if(answer > 0){
            answer = 1;
        } else if (answer < 0) {
            answer = -1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}