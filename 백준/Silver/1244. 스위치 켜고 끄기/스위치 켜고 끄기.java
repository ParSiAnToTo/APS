import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] switchLine = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            switchLine[i] = Integer.parseInt(st.nextToken());
        }
        
        int studentNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNumber; i++) {
            String[] command = br.readLine().split(" ");
            int sex = Integer.parseInt(command[0]);
            int switchIndex = Integer.parseInt(command[1]) - 1;

            if (sex == 1) {
                for (int j = switchIndex; j < N; j += (switchIndex + 1)) {
                    switchLine[j] = 1 - switchLine[j];
                }
            } else {
                int left = switchIndex - 1;
                int right = switchIndex + 1;
                switchLine[switchIndex] = 1 - switchLine[switchIndex];

                while (true) {
                    if (left >= 0 && right < N && switchLine[left] == switchLine[right]) {
                        switchLine[left] = 1 - switchLine[left];
                        switchLine[right] = 1 - switchLine[right];
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(switchLine[i]).append(" ");
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}