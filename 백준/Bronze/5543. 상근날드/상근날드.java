import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int burgerPrice = 2001;
        int drinkPrice = 2001;
        for (int i = 0; i < 3; i++) {
            int price = Integer.parseInt(br.readLine());
            burgerPrice = Math.min(burgerPrice, price);
        }
        for (int i = 0; i < 2; i++) {
            int price = Integer.parseInt(br.readLine());
            drinkPrice = Math.min(drinkPrice, price);
        }

        int price = burgerPrice + drinkPrice -50;

        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();
    }
}