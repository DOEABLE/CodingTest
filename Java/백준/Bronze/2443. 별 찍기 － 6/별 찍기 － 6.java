import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = N; i > 0; i--) {
			for (int j = 1; j <= N - i; j++) {
				System.out.print(" ");

			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");

			}

			System.out.println();
		}
	}
}