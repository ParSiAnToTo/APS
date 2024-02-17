import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] solution = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < solution.length; i++) { // array data input
			solution[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(solution); // array sorted

		// exception pattern check
		boolean isOnlyAlkali = false;
		boolean isOnlyAcid = false;
		if (solution[N - 1] < 0) {
			isOnlyAlkali = true;
		} else if (solution[0] > 0) {
			isOnlyAcid = true;
		}

		if (!isOnlyAlkali && !isOnlyAcid) { // normal pattern check
			int start = 0;
			int end = N - 1;
			int minAcidity = Integer.MAX_VALUE;
			int solA = 0; // solution A acidity
			int solB = 0; // solution B acidity

			while (start < end) {
				int a = solution[start];
				int b = solution[end];
				int solutionVal = Math.abs(a + b); // solution acidity sum
				if (solutionVal < minAcidity) { // acidity update
					minAcidity = solutionVal;
					solA = a;
					solB = b;
				}

				// pointer move
				if (a + b > 0) {
					end--;
				} else {
					start++;
				}

			}
			bw.write(solA + " " + solB + "\n");

		} else { // exception pattern answer
			if (isOnlyAlkali) {
				bw.write(solution[N - 2] + " " + solution[N - 1] + "\n");
			} else {
				bw.write(solution[0] + " " + solution[1] + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class