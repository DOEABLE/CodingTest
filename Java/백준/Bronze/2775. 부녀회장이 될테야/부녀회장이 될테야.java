import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());//층 수
			int N = Integer.parseInt(br.readLine());//호 수
			//1-N까지 배열에 저장
			int[] arr = new int[N];

			//0층
			for (int j = 1; j <= N; j++) {
				arr[j - 1] = j;
			}

			//K층까지 사람 수를 연산해서 저장
			for (int j = 0; j < K; j++) {
				for (int k = 1; k < N; k++) {
					arr[k] += arr[k - 1];
				}
			}
			System.out.println(arr[N - 1]);
		}

	}
}