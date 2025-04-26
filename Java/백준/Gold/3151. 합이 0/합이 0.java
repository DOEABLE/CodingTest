import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/**
		 * 3명의 코딩실력의 합이 0이 되는 팀을 만들어야 함. 팀을 얼마나 많이 만들 수 있는지계산.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long cnt = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] > 0)
				break;

			int num = arr[i];
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				int sum = num + arr[left] + arr[right];

				if (sum == 0) {
					int l = 1;
					int r = 1;

					if (arr[left] == arr[right]) {
						int n = right - left + 1;
						cnt += Combination(n);
						break;
					}
					while (arr[left] == arr[left + 1]) {
						l++;
						left++;
					}
					while (arr[right] == arr[right - 1]) {
						r++;
						right--;
					}
					cnt += l * r;
				}
				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static long Combination(int n) {
		return n * (n - 1) / 2;
	}
}
