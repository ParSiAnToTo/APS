import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] point = new int[n];
		

		for (int i = 0; i < n; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(point); 
		
		int threshold = (int) Math.round(n * 0.15);

		int sum = 0;
		for (int i = threshold; i < n - threshold; i++) {
			sum += point[i];
		}
	
		
		int result = (int) Math.round((double) sum / (n - threshold * 2));
		System.out.println(result);

	} // end of main


} // end of class
