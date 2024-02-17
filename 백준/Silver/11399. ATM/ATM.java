import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;



public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
	
		for (int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		br.close();
		Arrays.sort(arr);
		int[] arr2 = new int[N];
		arr2[0] = arr[0];
		for (int i =1; i < N; i++) {
			arr2[i] = arr[i]+arr2[i-1]; 
		}
		
		int sum = 0;
		for (int i =0; i < N; i++) {
			sum += arr2[i];
		}
		
				
			System.out.println(sum);
			bw.close();
		}

	}
