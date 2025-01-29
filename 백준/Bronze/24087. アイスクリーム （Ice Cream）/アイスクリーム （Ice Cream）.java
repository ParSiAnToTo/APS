import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int S = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int gap = S - A;
        int price = 250;
        if (gap > 0) {
            price += (gap % B != 0 ? gap / B + 1 : gap / B) * 100;
        }

        result.append(price);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}