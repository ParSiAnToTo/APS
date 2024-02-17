import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] arr = new int[line.length()];
		for (int i = 0; i < line.length(); i++) {
			arr[i] = line.charAt(i) - '0';
		}
		
		quickSort(arr, 0, line.length()-1);
		for(int a:arr)
			System.out.print(a);

	}//main

	public static int partition(int[] array, int start, int end) {
		int pivot = array[start];
		int i = start - 1;
		int j = end + 1;

		while (true) {

			do {
				i++;
			} while (array[i] > pivot);

			do {
				j--;
			} while (array[j] < pivot);

			if (i >= j) {
				return j;
			}

			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;

		}
	} // partition

	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int newPivot = partition(array, start, end);
			
			quickSort(array, start, newPivot); //split left
			quickSort(array, newPivot+1, end); //split right
		}
	} // quickSort

}// class