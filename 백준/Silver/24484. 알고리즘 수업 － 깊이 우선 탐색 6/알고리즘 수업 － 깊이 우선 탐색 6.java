import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] depthList;
    static int[] visitedList;
    static int index;

    static void dfs(int start, int depth) {
        visited[start] = true;
        visitedList[start] = index++;
        depthList[start] = depth;
        for (int i : graph[start]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i < N + 1; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        visited = new boolean[N + 1];
        depthList = new int[N + 1];
        visitedList = new int[N + 1];
        Arrays.fill(depthList, -1);
        index = 1;

        dfs(R, 0);

        Long answer = 0L;
        for (int i = 1; i < N + 1; i++) {
            answer += (long) depthList[i] * visitedList[i];
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class