import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int fNum = Integer.parseInt(br.readLine());
		int stair[] = new int[fNum + 1];
		int dp[] = new int[fNum + 1];

		for (int i = 1; i <= fNum; i++){
			stair[i] = Integer.parseInt(br.readLine());
    }
		dp[1] = stair[1];
		if (fNum >= 2)
			dp[2] = stair[1] + stair[2];

		for (int i = 3; i <= fNum; i++)
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];

		System.out.println(dp[fNum]);
	}
}