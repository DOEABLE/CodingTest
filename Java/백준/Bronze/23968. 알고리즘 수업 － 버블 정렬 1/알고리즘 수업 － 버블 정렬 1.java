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
		bubbleSort(arr, K);
	}

	public static void bubbleSort(int[] A, int K) {
		int count = 0;
		int N = A.length;
		for (int last = N - 1; last >= 1; last--) {
			for (int i = 0; i < last; i++) {
				if (A[i] > A[i + 1]) {
					int temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
					count++;
					if (count == K) {
						System.out.println(A[i] + " " + A[i + 1]);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
