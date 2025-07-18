import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> divisors = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int namuge = N % i;
			if (namuge == 0) {
				divisors.add(i);
			}
		}
		//System.out.println(divisors.size());

		if (divisors.size() >= K) {
			System.out.println(divisors.get(K - 1));
		} else {
			System.out.println("0");
		}
	}
}