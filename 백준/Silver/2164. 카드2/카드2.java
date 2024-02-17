import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i =1; i<=N; i++) {
			queue.offer(i);
		}
		
		//card
		while(queue.size()>1) {
			queue.poll();
			int move = queue.poll();
			queue.offer(move);
		}
		
		System.out.println(queue.peek());
		
	}
}
