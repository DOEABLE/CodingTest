import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dfs
public class Main {

	static int[] dp = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //타일 길이

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		//-1로 초기화
		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(tile(N));

	}

	public static int tile(int N) {
		if (dp[N] == -1) {
			dp[N] = (tile(N - 1) + tile(N - 2)) % 15746;
		}
		return dp[N];
	}

}