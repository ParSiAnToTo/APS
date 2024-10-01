import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        String oddLine = "* ";
        String evenLine = " *";

        for (int i = 1; i <= N; i++) {
            if(i % 2 == 1){
                sb.append(oddLine.repeat(N)).append("\n");
            } else {
                sb.append(evenLine.repeat(N)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}