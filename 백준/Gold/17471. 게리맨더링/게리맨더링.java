import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Ward {
		int idx;
		int electorNum;

		public Ward(int idx, int electorNum) {
			this.idx = idx;
			this.electorNum = electorNum;
		}

	}

	static int N;
	static Ward[] wards;
	static ArrayList<ArrayList<Integer>> list;
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;

	static void comb(int start, int n, int count, ArrayList<Integer> resultA) {
		if (count == 0) {
			gerrymandering(resultA);
			return;
		}

		for (int i = start; i <= n; i++) {
			resultA.add(i);
			comb(i + 1, n, count - 1, resultA);
			resultA.remove(resultA.size() - 1);
		}
	}

	static void gerrymandering(ArrayList<Integer> resultA) {
		if (!isConnect( wards[resultA.get(0)].idx, resultA, resultA.size() ) ) {
			return;
		}

		ArrayList<Integer> resultB = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (resultA.contains(i)) {
				continue;
			}
			resultB.add(i);
		}

		if (!isConnect(wards[resultB.get(0)].idx, resultB, resultB.size())) {
			return;
		}

		int sumA = 0;
		for (int i = 0; i < resultA.size(); i++) {
			sumA += wards[resultA.get(i)].electorNum;
		}
		int sumB = 0;
		for (int i = 0; i < resultB.size(); i++) {
			sumB += wards[resultB.get(i)].electorNum;
		}

		int result = Math.abs(sumA - sumB);
		ans = Math.min(ans, result);
	}

	static boolean isConnect(int num, ArrayList<Integer> arr, int size) {
        visited = new boolean[N + 1];
        visited[num] = true;
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(num);
		

		int cnt = 1;
		while (!queue.isEmpty()) {
			int st = queue.poll();


			for (int a : list.get(st)) {
				
				if (!visited[a] && arr.contains(a)) {
					visited[a] = true;
					cnt++;
					queue.offer(a);
				}
				
			}
		}

		if (cnt == size) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		wards = new Ward[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < wards.length; i++) {
			int electorNum = Integer.parseInt(st.nextToken());
			wards[i] = new Ward(i, electorNum);
		}

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int linkNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < linkNum; j++) {
				int linkedIdx = Integer.parseInt(st.nextToken());
				list.get(i).add(linkedIdx);
			}
		}
		
		ArrayList<Integer> resultA = new ArrayList<>();

		for (int i = 1; i <= N / 2; i++) {
			comb(1, N, i, resultA);
		}

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);

	}// end of main

}// end of class