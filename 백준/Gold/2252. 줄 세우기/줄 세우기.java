import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] adjList = new ArrayList[N + 1];
        //ArrayList를 value로 갖는 Integer array List adjList 생성
		int[] degree = new int[N + 1]; //진입차수 확인하는 배열 생성
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		} //adjList 초기값 입력

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A].add(B);
			degree[B]++;
		} //가중치 없으므로 간선자료와 진입 차수 입력

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		} //진입차수 0인 노드 전부 삽입

		while (!queue.isEmpty()) { 
			int student = queue.poll(); //진입 차수 0인 학생 우선 배출
			sb.append(student).append(" ");

			for (int i : adjList[student]) { 
                //해당 학생과 키를 재고 더 큰 학생들 진입 차수 차감
				degree[i]--;
				if (degree[i] == 0) { //그 학생이 진입 차수 0이 되었다면 큐 삽입
					queue.offer(i);
				}

			}
		}

		System.out.println(sb.toString());

	}// end of main

}// end of class