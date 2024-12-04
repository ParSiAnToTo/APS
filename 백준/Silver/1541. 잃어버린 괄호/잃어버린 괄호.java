import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split("-");
        for (int i = 0; i < line.length; i++) {
            if (!line[i].equals("+")) {
                int subSum = 0;
                String[] subLine = line[i].split("\\+");
                for (int j = 0; j < subLine.length; j++) {
                    if (!subLine[j].equals("+")) {
                        subSum += Integer.parseInt(subLine[j]);
                    }
                }
                line[i] = String.valueOf(subSum);
            }
        }
        int sum = Integer.parseInt(line[0]);
        for (int i = 1; i < line.length; i++) {
            sum -= Integer.parseInt(line[i]);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}