import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] child = new TrieNode[10];
        boolean isEnd;

        public TrieNode() {
            isEnd = false;
            for (int i = 0; i < 10; i++) {
                child[i] = null;
            }
        }
    }

    static class Trie {
        private TrieNode root;
        boolean consistency;

        public Trie() {
            root = new TrieNode();
            consistency = true;
        }

        public void insert(String phoneNumber) {
            TrieNode node = root;
            for (int i = 0; i < phoneNumber.length(); i++) {
                int index = phoneNumber.charAt(i) - '0';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];

                if (node.isEnd) {
                    consistency = false;
                }
            }
            node.isEnd = true;

            for (int i = 0; i < 10; i++) {
                if (node.child[i] != null) {
                    consistency = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(st.nextToken());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            Trie program = new Trie();
            String[] list = new String[n];
            for (int j = 0; j < n; j++) {
                list[j] = br.readLine();
            }
            Arrays.sort(list);
            for (int j = 0; j < n; j++) {
                program.insert(list[j]);
                if (!program.consistency) {
                    break;
                }
            }

            if (program.consistency) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}