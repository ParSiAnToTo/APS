import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) { //오름차순 정렬
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 집의 개수 N
		int M = Integer.parseInt(st.nextToken()); // 길의 개수 M

		List<Edge>[] adjList = new ArrayList[N+1]; // 인접 리스트

		for (int i = 0; i < N+1; i++) { // 인접 리스트 초기화
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken()); // 시작 지점
			int B = Integer.parseInt(st.nextToken()); // 도착 지점
			int cost = Integer.parseInt(st.nextToken()); // 길 유지비

			adjList[A].add(new Edge(A, B, cost));
			adjList[B].add(new Edge(B, A, cost)); // 양방향
		}
		
		boolean[] visited = new boolean[N+1]; //방문 배열
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(); //우선순위 큐
		
		visited[0]=true; // 0번 마을 없으므로 체크
		visited[1]=true; // 시작지점 체크
		
		pq.addAll(adjList[1]); // 시작지점 경로 전부 addAll
		
		int idx = 1; // 선택한 집 개수 저장 파라메터
		int minSum = 0; //값 저장 파라메터
		int max = 0; // 마지막에 끊어서 마을을 분리할 길의 유지비 저장 파라메터
		
		while(idx != N) {
			Edge e = pq.poll();
			
			if(visited[e.ed]) { // addAll이므로 방문한 집 무시
				continue;
			}
			
			if(max < e.cost) { // 길의 최대 유지비 갱신
				max = e.cost;
			}
			
			minSum += e.cost; //유지비 합
			pq.addAll(adjList[e.ed]); //해당 집과 경로가 존재하는 집 전부 addAll
			visited[e.ed] = true; // 방문 체크
			idx++; //방문한 집 카운트 증가
		}
		
		System.out.println(minSum - max);
		

	} // end of main

} // end of class