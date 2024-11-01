import java.io.*;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        LocalDateTime date = LocalDateTime.now();
        sb.append(date.getYear()).append("-")
                .append(String.format("%02d", date.getMonthValue())).append("-")
                .append(String.format("%02d", date.getDayOfMonth()));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}