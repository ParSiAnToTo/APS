import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<>();
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {

			int input = sc.nextInt();
			if (input == 0)
				stack.pop();
			else
				stack.push(input);
		}

		int sum = 0;
		if (stack.isEmpty())
			System.out.println(sum);
		else {
			for (int a : stack) {
				sum += a;
			}
			System.out.println(sum);
		}
	}
}
