import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int root;
    static int deleteNode;
    static int leafNodeCount;

    static void dfs(int node) {
        visited[node] = true;
        boolean hasChild = false;
        for (int cur : graph[node]) {
            if (cur != deleteNode && !visited[cur]) {
                hasChild = true;
                dfs(cur);
            }
        }
        if (!hasChild) {
            leafNodeCount++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                graph[parent].add(i);
                graph[i].add(parent);
            }
        }
        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            sb.append(0);
        } else {
            dfs(root);
            sb.append(leafNodeCount);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class