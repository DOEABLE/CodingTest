import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int findX = Integer.parseInt(st.nextToken());
		int findY = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			a.get(x).add(y);
			a.get(y).add(x);
		}

		boolean[] visited = new boolean[N + 1];
		DFS(a, visited, findX, findY, 0);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static void DFS(ArrayList<ArrayList<Integer>> a, boolean[] visited, int pos, int find, int cnt) {
		visited[pos] = true;

		for (int i : a.get(pos)) {
			if (!visited[i]) {
				if (i == find) {
					ans = cnt + 1;
					return;
				}
				DFS(a, visited, i, find, cnt + 1);
			}
		}

	}
}