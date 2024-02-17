import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String[] messageSplit = message.split("");
        int len = message.length();

        int row = 0;
        int col = 0;

        find: for (int r = 100; r >= 1; r--) {
            for (int c = 1; c <= 100; c++) {
                if (r <= c && r * c == len) {
                    row = r;
                    col = c;
                    break find;
                }
            }
        }

        String[][] writeM = new String[row][col];
        int k = 0;
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                writeM[i][j] = messageSplit[k++];
            }

        }

        StringBuilder sb = new StringBuilder();
      for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
    	  sb.append(writeM[i][j]);
      }
  }

        System.out.println(sb);

    }

}