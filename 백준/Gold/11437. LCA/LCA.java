import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parentList, depthList;
    static List<Integer>[] graph;


    static int lca(int pairA, int pairB) {
        int pairADepth = depthList[pairA];
        int pairBDepth = depthList[pairB];

        if (pairADepth > pairBDepth) {
            while (pairADepth != pairBDepth) {
                pairA = parentList[pairA];
                pairADepth--;
            }
        } else if (pairBDepth > pairADepth) {
            while (pairBDepth != pairADepth) {
                pairB = parentList[pairB];
                pairBDepth--;
            }
        }

        int commonAncestor = 0;
        while (pairA != pairB) {
            pairA = parentList[pairA];
            pairB = parentList[pairB];
        }
        commonAncestor = pairA;

        return commonAncestor;
    }

    static void setTree(int now, int parent, int height) {
        depthList[now] = height;
        parentList[now] = parent;
        for (int next : graph[now]) {
            if (next != parent) {
                setTree(next, now, height + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        parentList = new int[N + 1];
        depthList = new int[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        setTree(1, 0, 1);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int ancestorNode = lca(nodeA, nodeB);
            sb.append(ancestorNode).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}