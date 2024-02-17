import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 파티의 수

		p = new int[N + 1];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int peopleNum = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		if (peopleNum == 0) {
			System.out.println(M);
		} else {
			boolean[] truth = new boolean[N + 1];
			for (int i = 0; i < peopleNum; i++) { // 진실을 아는 사람 저장
				truth[Integer.parseInt(st.nextToken())] = true;
			}

			List<List<Integer>> partyList = new ArrayList<>();
			for (int i = 0; i < M; i++) { // 리스트 초기화
				partyList.add(new ArrayList<>());
			}

			for (int i = 0; i < M; i++) { // 파티 리스트 입력
				st = new StringTokenizer(br.readLine(), " ");
				int guestNum = Integer.parseInt(st.nextToken()); // 파티 인원

				for (int j = 0; j < guestNum; j++) { // 해당 파티 손님 입력
					partyList.get(i).add(Integer.parseInt(st.nextToken()));
				}

				for (int j = 0; j < partyList.get(i).size() - 1; j++) { // 노드 연결
					int prevIdx = find(partyList.get(i).get(j));
					int nextIdx = find(partyList.get(i).get(j + 1));
					if (prevIdx < nextIdx) {
						union(prevIdx, nextIdx);
					} else {
						union(nextIdx, prevIdx);
					}
				}

			}

			boolean[] checked = new boolean[N + 1];
			for (int i = 1; i < checked.length; i++) { // 진실을 아는 사람 연결 노드 검증
				if (truth[i] && !checked[i]) {
					int root = find(i);
					for (int j = 1; j < checked.length; j++) {
						if (find(j) == root) {
							truth[j] = true;
							checked[j] = true;
						}
					}
				}
			}

			int count = 0; // 거짓말쟁이가 아닐 수 있는 파티 수
			for (int i = 0; i < M; i++) {
				for (int j = 1; j < truth.length; j++) {
					if (truth[j]) {
						if (partyList.get(i).contains(j)) {
							count++;
							break;
						}
					}
				}
			}

			System.out.println(M - count);

		}

	} // end of main

	static int find(int x) {
		if (x == p[x]) {
			return p[x];
		}
		p[x] = find(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}

} // end of class
