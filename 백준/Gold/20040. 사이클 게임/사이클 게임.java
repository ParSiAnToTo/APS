import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); 
			int n = Integer.parseInt(st.nextToken()); 
			int[][] edges = new int[n][2];

			for (int i = 0; i < n; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				edges[i][0] = x;
				edges[i][1] = y;
			}

			p = new int[m];

			for (int i = 0; i < p.length; i++) {
				p[i] = i;
			}

			int result = 0;
			for (int i = 0; i < n; i++) {
				int px = find(edges[i][0]);
				int py = find(edges[i][1]);

				if (px != py) {
					union(px, py);
				} else {
					result = i+1;
					break;
				}

			}
			System.out.println(result);
		

	} // end of main

	static int find(int x) {
		if (x == p[x]) {
			return p[x];
		}
		p[x]= find(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}

} // end of class
