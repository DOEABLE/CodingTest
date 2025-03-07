import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		int penney = 1;

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int c = Integer.parseInt(br.readLine());
			sb.append(c / quarter + " ");
			c %= quarter;

			sb.append(c / dime + " ");
			c %= dime;

			sb.append(c / nickel + " ");
			c %= nickel;

			sb.append(c / penney + "\n");
			c %= penney;
		}
		System.out.println(sb);
		br.close();
	}
}