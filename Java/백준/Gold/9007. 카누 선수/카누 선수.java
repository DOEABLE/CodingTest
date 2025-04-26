import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[][] C = new int[4][n];

			for (int c = 0; c < 4; c++) {
				st = new StringTokenizer(br.readLine());
				for (int num = 0; num < n; num++) {
					C[c][num] = Integer.parseInt(st.nextToken());
				}
			}

			int[] C1plusC2 = new int[n * n];
			int[] C3plusC4 = new int[n * n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					C1plusC2[i * n + j] = C[0][i] + C[1][j];
					C3plusC4[i * n + j] = C[2][i] + C[3][j];
				}
			}

			Arrays.sort(C1plusC2);
			Arrays.sort(C3plusC4);

			int res = C1plusC2[0] + C3plusC4[0];

			for (int i = 0; i < C1plusC2.length; i++) {
				int target =k - C1plusC2[i];
				int left = 0;
				int right = C3plusC4.length - 1;

				while (left <= right) {
					int mid = left + (right - left) / 2;
					int sum = C1plusC2[i] + C3plusC4[mid];

					if (Math.abs(k - sum) < Math.abs(k - res) || (Math.abs(k - sum) == Math.abs(k - res)
						&& sum < res))
						res = sum;

					if (sum == k)
						break;

					if (C3plusC4[mid] < target)
						left = mid + 1;
					else
						right = mid - 1;
				}
			}
			bw.write(String.valueOf(res) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}
}
