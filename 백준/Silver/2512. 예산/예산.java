import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] budget;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		budget = new int[N];
		int sum = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < budget.length; i++) {
			int num = Integer.parseInt(st.nextToken());
			budget[i] = num;
			sum += num;
			if (max < num) {
				max = num;
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());

		if (M > sum) {
			System.out.println(max);
		} else {
			System.out.println(upperBoundary(0, max));
		}

	}// end of main

	static int upperBoundary(int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			long budgetSum = 0;

			for (int i = 0; i < budget.length; i++) {
				if (budget[i] > mid) {
					budgetSum += mid;
				} else {
					budgetSum += budget[i];
				}
			}
			
			if(budgetSum<=M) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		
		return high;
	} // end of upperBoundary

}// end of class
