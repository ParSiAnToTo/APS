import java.io.*;
import java.util.*;

public class Main {

    static class Register {
        int decimal;
        String command;

        public Register(int decimal, String command) {
            this.decimal = decimal;
            this.command = command;
        }
    }

    static String calculator(int startDecimal, int targetDecimal) {
        boolean[] visited = new boolean[10001];
        Queue<Register> q = new LinkedList<>();
        q.add(new Register(startDecimal, ""));
        visited[startDecimal] = true;
        while (!q.isEmpty()) {
            Register now = q.poll();
            if (now.decimal == targetDecimal) {
                return now.command;
            }

            Register nextD = commandD(now.decimal, now.command);
            Register nextS = commandS(now.decimal, now.command);
            Register nextL = commandL(now.decimal, now.command);
            Register nextR = commandR(now.decimal, now.command);

            if (!visited[nextD.decimal]) {
                visited[nextD.decimal] = true;
                q.add(nextD);
            }
            if (!visited[nextS.decimal]) {
                visited[nextS.decimal] = true;
                q.add(nextS);
            }
            if (!visited[nextL.decimal]) {
                visited[nextL.decimal] = true;
                q.add(nextL);
            }
            if (!visited[nextR.decimal]) {
                visited[nextR.decimal] = true;
                q.add(nextR);
            }
        }

        return "";
    }

    static Register commandD(int decimal, String command) {
        return new Register((decimal * 2) % 10000, command + "D");
    }

    static Register commandS(int decimal, String command) {
        return new Register(decimal == 0 ? 9999 : decimal - 1, command + "S");
    }

    static Register commandL(int decimal, String command) {
        return new Register((decimal % 1000) * 10 + decimal / 1000, command + "L");
    }

    static Register commandR(int decimal, String command) {
        return new Register((decimal % 10) * 1000 + decimal / 10, command + "R");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            String commandLog = calculator(A, B);
            sb.append(commandLog).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class