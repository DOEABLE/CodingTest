import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());    //readLine()으로 입력값을 읽음.
		long[][] dp = new long[N + 1][10];

		//초기화
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}

		//점화식 계산
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					//마지막 숫자가 0인 경우, 이전 길이는 1로 끝났어야 함.
					dp[i][j] = dp[i - 1][1];
				} else if (j == 9) {
					//마지막 숫자가 9인 경우, 이전 길이는 8로 끝났어야 함.
					dp[i][j] = dp[i - 1][8];
				} else {
					//마지막 숫자가 1-8인 경우, 이전 길이는 j-1 or j+1로 끝났어야 함.
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}

		long result = 0;
		for (int i = 0; i < 10; i++) {
			result = (result + dp[N][i]) % 1000000000;
		}
		System.out.println(result);
	}

}