import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        if(input.length() == 3){
            for (int i = 0; i < 3; i++) {
                if(input.charAt(i) - '0' == 0){
                    if(i == 1){
                        int answer = 10 + (input.charAt(2) - '0');
                        bw.write(String.valueOf(answer));
                    } else {
                        int answer = 10 + (input.charAt(0) - '0');
                        bw.write(String.valueOf(answer));
                    }
                    break;
                }
            }
        } else if (input.length() == 4){
            int answer = 20;
            bw.write(String.valueOf(answer));
        } else {
            int answer = (input.charAt(0) - '0') + (input.charAt(1) - '0');
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
    }
}