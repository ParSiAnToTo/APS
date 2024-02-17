import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int perTwo, len, ans=Integer.MAX_VALUE;
	static List<Integer>[] list;
	static boolean flag;
	static Queue<Integer> q;
	static boolean[] chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int perOne = Integer.parseInt(st.nextToken());
		perTwo = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);

		}
		len = 0;
		q = new LinkedList<>();
		chk = new boolean[n + 1];
		dfs(perOne, len);
		if (!flag) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}// end of main

	static void dfs(int st, int length) {
		if (st == perTwo) {
			flag = true;
			ans = Math.min(ans, length);
		}

		q.offer(st);
		chk[st]=true;
		while (!q.isEmpty()) {
			int num = q.poll();

			for (int i = 0; i < list[num].size(); i++) {
				if (!chk[list[num].get(i)]) {
					dfs(list[num].get(i), length+1);
				}
			}
		}

	}

}// end of class