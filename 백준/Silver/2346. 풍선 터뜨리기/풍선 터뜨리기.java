import java.io.*;
import java.util.*;

public class Main {

    static class Balloon {
        int number;
        int memo;

        Balloon(int number, int memo) {
            this.number = number;
            this.memo = memo;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Deque<Balloon> balloons = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        Balloon current = balloons.poll();
        int memo = current.memo;
        sb.append(current.number).append(" ");

        while (!balloons.isEmpty()) {
            if (memo > 0) {
                for (int i = 1; i < Math.abs(memo); i++) {
                    balloons.addLast(balloons.pollFirst());
                }
                current = balloons.pollFirst();
            } else {
                for (int i = 1; i < Math.abs(memo); i++) {
                    balloons.addFirst(balloons.pollLast());
                }
                current = balloons.pollLast();
            }
            memo = current.memo;
            sb.append(current.number).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
