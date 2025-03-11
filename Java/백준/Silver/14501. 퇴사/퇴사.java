import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] t = new int[N];
		int[] p = new int[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			if (i + t[i] <= N) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}

			//다음 날 오늘까지의 일한 부분을 누적산
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N]);
	}

}