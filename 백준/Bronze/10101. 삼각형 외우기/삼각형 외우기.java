import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] radArray = new int[3];
        for (int i = 0; i < 3; i++) {
            radArray[i] = Integer.parseInt(br.readLine());
        }
        if (radArray[0] == 60 && radArray[1] == 60 && radArray[2] == 60) {
            sb.append("Equilateral");
        } else {
            if (radArray[0] + radArray[1] + radArray[2] == 180) {
                if (radArray[0] == radArray[1] || radArray[0] == radArray[2] || radArray[1] == radArray[2]) {
                    sb.append("Isosceles");
                } else {
                    sb.append("Scalene");
                }
            } else {
                sb.append("Error");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class