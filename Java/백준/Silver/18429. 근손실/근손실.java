import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N];
		result = new int[N];
		count = 0;

		permutation(0);

		System.out.println(count);

	}

	public static void permutation(int depth) {
		if (depth == N) {
			int muscle = 500;

			for (int i = 0; i < N; i++) {
				muscle = muscle + result[i] - K;

				if (muscle < 500)
					return;//500보다 작아지면 안됨.
			}
			count++;

			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			result[depth] = arr[i];
			permutation(depth + 1);
			visited[i] = false;
		}
	}
}