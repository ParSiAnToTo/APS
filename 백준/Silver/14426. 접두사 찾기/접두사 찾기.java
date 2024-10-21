import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;

        public TrieNode() {
            isEnd = false;
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];
            }
            node.isEnd = true;
        }

        public boolean searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (node.child[index] == null) {
                    return false;
                }
                node = node.child[index];
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            trie.insert(st.nextToken());
        }

        int prefixCount = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (trie.searchPrefix(st.nextToken())) {
                prefixCount++;
            }
        }

        bw.write(String.valueOf(prefixCount));
        bw.flush();
        bw.close();
    }
}