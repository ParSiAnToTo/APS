import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            Long x = Long.parseLong(input[0]);
            Long y = Long.parseLong(input[1]);
            Long add = x + y;
            sb.append(add).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
