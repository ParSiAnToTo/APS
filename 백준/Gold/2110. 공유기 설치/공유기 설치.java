import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] temp, house;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 집 개수
		C = Integer.parseInt(st.nextToken()); // 공유기설치 수
		house = new int[N];
		temp = new int[N];
		for (int i = 0; i < house.length; i++) { // 집 좌표 입력
			house[i] = Integer.parseInt(br.readLine());
		}

//		mergeSort(house, 0, N - 1); //병합정렬
		Arrays.sort(house);
		int low = 1;
		int high = house[N-1]-house[0]+1;
		while(low <high) {
			int mid = (low + high)/2;
			if(routerInstall(mid)<C) {
				high=mid;
			} else {
				low = mid+1;
			}
			
		}
		
		System.out.println(low-1);
		

	}// end of main

//	static void mergeSort(int[] arr, int l, int r) {
//		if (l == r) { // 부분집합 크기 1
//			return;
//		}
//
//		int mid = (l + r) / 2;
//		mergeSort(arr, l, mid); //좌측 정렬
//		mergeSort(arr, mid + 1, r); //우측 정렬
//		merge(arr, l, mid, r);
//	} //end of mergeSort
//
//	static void merge(int[] arr, int l, int mid, int r) {
//		int left = l;
//		int right = mid + 1;
//		int idx = l;
//
//		while (left <= mid && right <= r) { //좌측 부분집합부터 정렬
//			if (arr[left] <= arr[right]) { 
//				temp[idx] = arr[left];
//				idx++;
//				left++;
//			} else {
//				temp[idx]=arr[right];
//				idx++;
//				right++;
//			}
//		}
//
//		if (left > mid) { //좌측정렬 완료 시 
//			while (right <= r) {
//				temp[idx] = arr[right];
//				idx++;
//				right++;
//			}
//		} else { // 우측정렬 완료 시
//			while (left <= mid) {
//				temp[idx] = arr[left];
//				idx++;
//				left++;
//			}
//		}
//
//		for (int i = 0; i < r; i++) { //정렬된 임시 배열 값 복사
//			arr[i] = temp[i];
//		}
//
//	}// end of merge
	
//	static int paraSearch(int low, int high) { //매개변수 탐색
//		if(low>=high) {
//			return low-1;
//		}
//		
//		int mid = (low + high) /2;
//		
//		if(routerInstall(mid)< C) { //설치 수가 부족하다면 
//			high = mid; //설치 거리 축소
//		} else { //설치 수 이상이라면
//			low = mid+1; //설치 거리 증가
//		}
//		
//		return paraSearch(low, high);
//	} //end of paraSearch
	
	static int routerInstall(int dist) { //설치 수 연산
		int count =1;
		int prevPoint = house[0]; //첫 집에 반드시 설치
		
		for (int i = 1; i < house.length; i++) {
			int nextPoint = house[i]; // 다음 설치 집의 거리
			
			if(nextPoint - prevPoint >= dist) { //기준 거리를 넘어선다면
				count++; //설치
				prevPoint = nextPoint; //다음 기준 거리 생신
			}
		}
		
		return count;
	} //end of routerInstall

}// end of class