import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L];
		int[] count = new int[N+1];
		
		
		int ifmax = -1;
		int idxcnt = 0;	
		int ifidx =0;
		for(int i =0; i<N; i++) {
			String line = br.readLine();
			String[] lineSplit = line.split(" ");
			int startIdx = Integer.parseInt(lineSplit[0]);
			int endIdx = Integer.parseInt(lineSplit[1]);
			idxcnt++;
			if(endIdx-startIdx >ifmax) {
				ifmax=endIdx-startIdx;
				ifidx = idxcnt;
			}
			for(int x = startIdx-1; x<endIdx; x++) {
				if(cake[x]==0) {
					cake[x] = i+1;
					count[i+1]++;
				}
			}
		}

			int max = -1;
			int numidx = -1;
			for(int num = 1; num<N+1; num++) {

				if(count[num]>max) {
					max = count[num];
					numidx = num;

				}
			}
		
			
			
			
		
		
		System.out.println(ifidx);
		System.out.println(numidx);
	}
}
