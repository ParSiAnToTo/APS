import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>(); // 큐 선언
		for (int i = 1; i <= N; i++) { // 큐에 1~N 삽입
			queue.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (queue.size() != 1) { // 큐 크기가 K보다 작아질 때까지 요세푸스 순열 반복
			for (int i = 1; i < K; i++) { // K번째가 되기 전까지 큐에서 poll - offer 반복
				int reInsult = queue.poll();
				queue.offer(reInsult);
			}
			sb.append(queue.poll() + ", "); // K번째 값 더하기
		}
		sb.append(queue.poll() + ">"); //마지막 값 추가 후 닫기

		System.out.println(sb); //결과 출력

	}
}