import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		System.out.println(pow(A, B, C));

	}

	public static long pow(long A, long B, long C) {
		if (B == 0)
			return 1;
		long half = pow(A, B / 2, C);
		long result = (half * half) % C;

		if (B % 2 == 1) {//B가 홀수일때
			result = (result * A) % C;
		}

		return result;
	}

}