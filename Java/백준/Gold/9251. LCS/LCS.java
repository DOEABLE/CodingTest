import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] A, B;
	static int[][] dp;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//각 문자열 입력 받기
		String a = br.readLine();
		String b = br.readLine();
		//문자열의 길이 저장
		int alength = a.length();
		int blength = b.length();

		A = new char[alength];
		B = new char[blength];
		for (int i = 0; i < A.length; i++) {
			A[i] = a.charAt(i);
		}
		for (int i = 0; i < B.length; i++) {
			B[i] = b.charAt(i);
		}
		dp = new int[blength + 1][alength + 1];    //dp테이블의 크기

		for (int i = 1; i <= blength; i++) {
			for (int j = 1; j <= alength; j++) {
				if (B[i-1] == A[j-1]) {            //비교하는 두 문자가 같은 경우
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

				}
			}
		}
		System.out.println(dp[blength][alength]);
	}

}