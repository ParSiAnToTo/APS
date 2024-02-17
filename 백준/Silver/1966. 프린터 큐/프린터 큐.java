import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
		
		for (int testCase = 0; testCase < TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 문서 수
			int M = Integer.parseInt(st.nextToken()); // 목표 문서의 위치
			
			LinkedList<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.offer(i*1000 + priority); // offer/1000 = 문서 삽입 순서, offer % 1000 = 문서 중요도
			}
			
			int idx = 0; //순서 확인 파라미터
			
			while(!q.isEmpty()) {
				int target = q.poll();
				boolean chk = false; // 최중요도 체크
				
				int targetPrior = target%1000; // 문서 중요도
				
				for (int i = 0; i < q.size(); i++) {
					
					if(targetPrior < q.get(i)%1000) { //큐 내 더 중요한 문서가 있다면
						q.offer(target);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						// 그 이전 문서 전부 재삽입
						chk = true;
						// 미인쇄 확인
						break;
						// 현재 문서 대상 중요도 검사 중단
						
					}
					
					

				}
				
				if(chk == true) { // 미인쇄 시 다음 문서 중요도 검사
					continue;
				}
				
				idx++; // 인쇄 시 인쇄순서 증가
				if(target/1000 == M) { //이때 인쇄 문서의 순서가 목표값이라면
					break; // 인쇄 중단
				}
			}
			
			sb.append(idx).append("\n");
			
		} // end of TestCase
		
		System.out.println(sb.toString());
	
	} // end of main

} // end of class
