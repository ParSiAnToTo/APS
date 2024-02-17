import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static class Node {
        int v, w;
 
        public Node(int v, int w) {
 
            this.v = v;
            this.w = w;
        }
    }
 
    static final int INF = Integer.MAX_VALUE;
    static int V, E, weights;
    static List<Node>[] adjList;
    static int[] dist;
    static int[][] map;
    static int testCase=1;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while ((V = Integer.parseInt(br.readLine()))!=0 ) {
            E = 4 * V * (V - 1);
            map = new int[V][V];
 
            for (int i = 0; i < V; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < V; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
 
            adjList = new ArrayList[V * V];
            for (int i = 0; i < V * V; i++) {
                adjList[i] = new ArrayList<>();
            }
 
            dist = new int[V * V];
            Arrays.fill(dist, INF);
 
            for (int i = 0; i < V * V; i++) {
                if (i - V >= 0) { // 상
                    int ed = i - V;
                    weights = map[ed / V][ed % V];
                    adjList[i].add(new Node(ed, weights));
                }
 
                if (i + V < V * V) { // 하
                    int ed = i + V;
                    weights = map[ed / V][ed % V];
                    adjList[i].add(new Node(ed, weights));
                }
                if (i % V != 0) { // 좌
                    int ed = i - 1;
                    weights = map[ed / V][ed % V];
                    adjList[i].add(new Node(ed, weights));
                }
                if (i % V != V - 1) { // 우
                    int ed = i + 1;
                    weights = map[ed / V][ed % V];
                    adjList[i].add(new Node(ed, weights));
                }
            }
 
            dijkstra(0);

            sb.append("Problem ").append(testCase++).append(": ").append(dist[V * V - 1]+map[0][0]).append("\n");
        } // end testCase
        System.out.println(sb.toString());
 
    }// end of main
 
    static void dijkstra(int st) {
        boolean[] visited = new boolean[V * V];
        dist[st] = 0;
 
        for (int i = 0; i < V * V; i++) {
            int min = INF;
            int idx = -1;
 
            for (int j = 0; j < V * V; j++) {
                if (!visited[j] && min > dist[j]) {
                    min = dist[j];
                    idx = j;
                }
            }
 
            if (idx == -1) {
                break;
            }
 
            visited[idx] = true;
 
            for (Node curr : adjList[idx]) {
                if (!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w) {
                    dist[curr.v] = dist[idx] + curr.w;
                }
            }
        }
    }// dijkstra
 
}// end of class