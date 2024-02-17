import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});
		
		p = new int[V+1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		int res = 0;
		int pick = 0;
		
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			if(px!=py) {
				union(px,py);
				res += edges[i][2];
				pick++;
			}
			
			if(pick == V-1) {
				break;
			}
		}
		
		System.out.println(res);

	} //end of main
	
	
	static int findSet(int x) {
		if(x != p[x]) 
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y]=x;
	}
	

}//end of class
