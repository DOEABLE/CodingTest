import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph = new int[1001][1001];
	static boolean[] visited = new boolean[500000];
	//그룹에 정점이 들어왔는가?
	static int CC = 0;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int result = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;
		}

		for (int i = 1; i <= N; i++) {
			DFS(i);
			if (CC != 0) {
				result++;
			}
			//count가 정점의 갯수와 같다면 연결이 없는 정점이므로 result +1
			if (count == N) {
				result++;
			}
			CC = 0;
			count = 0;
		}
		System.out.println(result);
	}

	private static void DFS(int node) {
		visited[node] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[node][i] == 1) {
				DFS(i);
				CC++;
				count = 0;
			}
			//현재 정점과 연결된 정점이 없다면 count증가
			if (graph[node][i] == 0) {
				count++;
			}
		}
	}
}