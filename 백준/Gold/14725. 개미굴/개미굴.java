import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class TrieNode {
        TreeMap<String, TrieNode> foodInfo = new TreeMap<>();

        public TrieNode addChild(String child) {
            if (!foodInfo.containsKey(child)) {
                foodInfo.put(child, new TrieNode());
            }
            return foodInfo.get(child);
        }

        public void printFoodInfo(int depth) {
            for (String food : foodInfo.keySet()) {
                sb.append("--".repeat(depth)).append(food).append("\n");
                foodInfo.get(food).printFoodInfo(depth + 1);
            }
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String[] foods) {
            TrieNode node = root;
            for (String food : foods) {
                node = node.addChild(food);
            }
        }

        public void print() {
            root.printFoodInfo(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Trie anthill = new Trie();

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());

            String[] foods = new String[len];
            for (int i = 0; i < len; i++) {
                foods[i] = st.nextToken();
            }
            anthill.insert(foods);
        }

        anthill.print();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}