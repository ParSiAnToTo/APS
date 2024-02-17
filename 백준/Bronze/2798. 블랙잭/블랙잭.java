import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] lines = line.split(" ");
		int N = Integer.parseInt(lines[0]);
		int M = Integer.parseInt(lines[1]);

		String line2 = br.readLine();
		String[] line2s = line2.split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line2s[i]);
		}
		br.close();

		int res = 0;
		int temp = 0;
		boolean coll = false;

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {

					temp = arr[i] + arr[j] + arr[k];

					if (temp == M)
						coll = true;

					if (res < temp && temp < M)
						res = temp;

				}
			}
		}
		
		if(coll)
			System.out.println(M);
		else
			System.out.println(res);

	}
}