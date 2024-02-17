import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String command = sc.next();
		sc.close();
		Stack<Character> stackLR = new Stack<>();
		Stack<Character> stackSK = new Stack<>();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(command.charAt(i) =='S') {
				stackSK.push(command.charAt(i));
			} else if(command.charAt(i) =='L') {
				stackLR.push(command.charAt(i));
			} else if(command.charAt(i) =='R') {
				if(stackLR.isEmpty()) {
					break;
				} else if(stackLR.peek() == 'L') {
					stackLR.pop();
					cnt++;
				}
				
			} else if(command.charAt(i) =='K') {
				if(stackSK.isEmpty()) {
					break;
				} else if(stackSK.peek() == 'S') {
					stackSK.pop();
					cnt++;
				}
				
			} else {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}
}