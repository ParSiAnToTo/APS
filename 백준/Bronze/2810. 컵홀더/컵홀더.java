import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] sheet = line.split("");
		int ans = 1;
		int cnt = 0;


		for (int i = 0; i < N; i++) {
			if (sheet[i].equals("L")) 
				cnt++;
			ans++;
		}
		
		ans -= cnt / 2;
		if(N<ans)
			ans =N;



		System.out.println(ans);

	}
}
