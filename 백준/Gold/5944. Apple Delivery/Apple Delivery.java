import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int C, P, PB, PA1, PA2;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;

    static class Node {
        int ed;
        int weight;

        public Node(int ed, int weight) {
            this.ed = ed;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        PB = Integer.parseInt(st.nextToken());
        PA1 = Integer.parseInt(st.nextToken());
        PA2 = Integer.parseInt(st.nextToken());

        list = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < P + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, weight));
            list.get(b).add(new Node(a, weight));
        }

        // Calculate the minimum distance from PB to PA1 + PA1 to PA2
        long pbToPa1 = dijk(PB, PA1) + dijk(PA1, PA2);

        // Calculate the minimum distance from PB to PA2 + PA2 to PA1
        long pbToPa2 = dijk(PB, PA2) + dijk(PA1, PA2);

        // Output the shorter of the two distances
        long shortestPath = Math.min(pbToPa1, pbToPa2);
        System.out.println(shortestPath);
    }

    static int dijk(int st, int ed) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

        dist = new int[P + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[st] = 0;
        pq.offer(new Node(st, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
			if(dist[curr.ed]<curr.weight) {
			continue;
		}

            for (int i = 0; i < list.get(curr.ed).size(); i++) {
                Node nxt = list.get(curr.ed).get(i);

                if (dist[nxt.ed] > nxt.weight + curr.weight) {
                    dist[nxt.ed] = nxt.weight + curr.weight;
                    pq.offer(new Node(nxt.ed, dist[nxt.ed]));
                }
            }
        }

        return dist[ed];
    }
}