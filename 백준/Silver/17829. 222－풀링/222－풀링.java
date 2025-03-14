import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = DnC(0, 0, N);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    private static int DnC(int r, int c, int size) {
        if (size == 1) {
            return arr[r][c];
        }

        int newSize = size / 2;

        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(arr[r + 2 * i][c + 2 * j]);
                subList.add(arr[r + 2 * i][c + 2 * j + 1]);
                subList.add(arr[r + 2 * i + 1][c + 2 * j]);
                subList.add(arr[r + 2 * i + 1][c + 2 * j + 1]);
                subList.sort(Integer::compareTo);
                arr[r + i][r + j] = subList.get(2);
            }
        }
        return DnC(r, c, newSize);
    }
}