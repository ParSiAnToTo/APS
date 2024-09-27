import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Double N = Double.parseDouble(br.readLine());

        if(N < 0){
            if(N < Integer.MIN_VALUE){
                sb.append("long long");
            } else if (N < Math.pow(-2, 15)){
                sb.append("int");
            } else {
                sb.append("short");
            }
        } else {
            if(N > Integer.MAX_VALUE){
                sb.append("long long");
            } else if (N > Math.pow(2, 15) - 1){
                sb.append("int");
            } else {
                sb.append("short");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}