import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

	static class Dict implements Comparable<Dict> {
		String sentense;
		int len;

		public Dict(String sentense, int len) {
			this.sentense = sentense;
			this.len = len;
		}

		@Override
		public int compareTo(Dict o) {
			if (this.len != o.len) {
				return this.len - o.len;
			} else {
				return this.sentense.compareTo(o.sentense);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		PriorityQueue<Dict> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String sentense = br.readLine();

			if (!set.contains(sentense)) {
				set.add(sentense);
			} else {
				continue;
			}
			pq.add(new Dict(sentense, sentense.length()));
		}

		while (!pq.isEmpty()) {
			bw.write(pq.poll().sentense + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class