import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		insertionSort(arr, K);
	}

	public static void insertionSort(int[] A, int K) {
		int count =0;
		int N = A.length;
		for (int i = 1; i < N; i++) {
			int j = i - 1;
			int newItem = A[i];

			//이 지점에서 A배열은 이미 정렬되어있는 상태
			while (0 <= j && newItem < A[j]) {
				A[j + 1] = A[j];
				j--;
				count++;
				if(count==K){
					System.out.println(A[j+1]);
					return;
				}
			}
			if (j + 1 != i) {//key를 새로 삽입할 때도 count+1
				A[j + 1] = newItem;
				count++;
				if(count==K){
					System.out.println(newItem);
					return;
				}
			}
		}
		System.out.println(-1);
	}
}