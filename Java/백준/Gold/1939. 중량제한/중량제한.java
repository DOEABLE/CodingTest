import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, A, B, start, end;
	static ArrayList<Node> node[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		node = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)//섬의 갯수
			node[i] = new ArrayList<>();//데이터 초기화

		for (int i = 0; i < M; i++) {//다리에 대한 정보를 나타낼 행 수
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			node[from].add(new Node(to, weight));
			node[to].add(new Node(from, weight));
			end = Math.max(end, weight);

		}

		//마지막 줄에 들어갈 공장이 위치한 섬 번호
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		while (start <= end) {
			int mid = (start + end) / 2;
			if (BFS(mid))
				start = mid + 1;
			else
				end = mid - 1;
		}
		bw.write(String.valueOf(end));
		br.close();
		bw.close();

	}

	static boolean BFS(int limit) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(A);
		visited[A] = true;

		while (!q.isEmpty()) {
			int front = q.poll();
			if (front == B)
				return true;

			for (int i = 0; i < node[front].size(); i++) {
				int to = node[front].get(i).to;
				int weight = node[front].get(i).weight;
				if (visited[to] || weight < limit)
					continue;
				visited[to] = true;
				q.offer(to);
			}
		}
		return false;
	}

	static class Node {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}