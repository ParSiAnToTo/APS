import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String cheerfulMessage = "강한친구 대한육군";
        sb.append(cheerfulMessage).append("\n").append(cheerfulMessage);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class