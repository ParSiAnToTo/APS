import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		int len;

		public Edge(int st, int ed, int len) {
			this.st = st;
			this.ed = ed;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return this.len - o.len;
		}
	}

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		ArrayList<Edge> xLine = new ArrayList<>();
		ArrayList<Edge> yLine = new ArrayList<>();
		ArrayList<Edge> zLine = new ArrayList<>();

		for (int i = 0; i < N; i++) { // i : planet index
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // coor x
			int y = Integer.parseInt(st.nextToken()); // coor y
			int z = Integer.parseInt(st.nextToken()); // coor z
			xLine.add(new Edge(i, 0, x));
			yLine.add(new Edge(i, 0, y));
			zLine.add(new Edge(i, 0, z));
		}

		p = new int[N + 1];

		for (int i = 0; i < N+1; i++) { //parents init
			p[i] = i;
		}

		Collections.sort(xLine);
		Collections.sort(yLine);
		Collections.sort(zLine);

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 1; i < N; i++) { // DESC
			pq.add(new Edge(xLine.get(i).st, xLine.get(i - 1).st, Math.abs(xLine.get(i).len - xLine.get(i - 1).len)));
			pq.add(new Edge(yLine.get(i).st, yLine.get(i - 1).st, Math.abs(yLine.get(i).len - yLine.get(i - 1).len)));
			pq.add(new Edge(zLine.get(i).st, zLine.get(i - 1).st, Math.abs(zLine.get(i).len - zLine.get(i - 1).len)));
		}

		for (int i = 0; i < N - 1; i++) { // ASC
			pq.add(new Edge(xLine.get(i).st, xLine.get(i + 1).st, Math.abs(xLine.get(i).len - xLine.get(i + 1).len)));
			pq.add(new Edge(yLine.get(i).st, yLine.get(i + 1).st, Math.abs(yLine.get(i).len - yLine.get(i + 1).len)));
			pq.add(new Edge(zLine.get(i).st, zLine.get(i + 1).st, Math.abs(zLine.get(i).len - zLine.get(i + 1).len)));
		}
		
		long cost = 0;
		while(!pq.isEmpty()) {
			Edge o = pq.poll();
			
			int px = find(o.st);
			int py = find(o.ed);
			if(px!=py) {
				union(px, py);
				cost += o.len;
			}
			
		}
		System.out.println(cost);

	} // end of main

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		if (x > y) {
			p[x] = y;
		} else {
			p[y] = x;
		}
	}

} // end of class