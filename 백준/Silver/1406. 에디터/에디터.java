import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Character> editorL = new Stack<>();
        Stack<Character> editorR = new Stack<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            editorL.push(input.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("L")) {
                if (!editorL.isEmpty()) {
                    editorR.push(editorL.pop());
                }
            } else if (command.equals("D")) {
                if (!editorR.isEmpty()) {
                    editorL.push(editorR.pop());
                }
            } else if (command.equals("B")) {
                if (!editorL.isEmpty()) {
                    editorL.pop();
                }
            } else if (command.equals("P")) {
                editorL.push(st.nextToken().charAt(0));
            }
        }

        while (!editorL.empty()) {
            editorR.push(editorL.pop());
        }
        while (!editorR.empty()) {
            sb.append(editorR.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
