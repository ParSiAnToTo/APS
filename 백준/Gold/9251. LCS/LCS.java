import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        char[] firstString = br.readLine().toCharArray();
        char[] secondString = br.readLine().toCharArray();
        int[][] lcsBoard = new int[firstString.length + 1][secondString.length + 1];
        for (int i = 1; i < lcsBoard.length; i++) {
            for (int j = 1; j < lcsBoard[i].length; j++) {
                if (firstString[i - 1] == secondString[j - 1]) {
                    lcsBoard[i][j] = lcsBoard[i - 1][j - 1] + 1;
                } else {
                    lcsBoard[i][j] = Math.max(lcsBoard[i - 1][j], lcsBoard[i][j - 1]);
                }
            }
        }

        int max = lcsBoard[firstString.length][secondString.length];
        sb.append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class