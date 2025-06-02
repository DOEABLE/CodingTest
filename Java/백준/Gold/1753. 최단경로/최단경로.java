import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static ArrayList<Node>[] graph;
	static boolean[] isVisited;
	static int[] dijkstraTable;

	static class Node {
		int n;
		int cost;

		Node(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());    //정점의 갯수
		E = Integer.parseInt(st.nextToken());    //간선의 갯수

		K = Integer.parseInt(br.readLine());    //시작노드

		graph = new ArrayList[V + 1];
		for (int i = 1; i < V+1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V+1; i++) {
			if (i == K) {
				sb.append(0).append("\n");
			} else if (dijkstraTable[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dijkstraTable[i]).append("\n");
			}
		}
		System.out.print(sb);
	}

	public static void dijkstra(int s) {//다익스트라 알고리즘. s는 시작 정점
		//*정점번호는 1부터 시작되고 배열은 0부터 시작하므로 V+1크기의 배열필요.
		isVisited = new boolean[V + 1];
		dijkstraTable = new int[V + 1];    //시작 정점부터 정점 i까지의 최단 거리.

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		Arrays.fill(dijkstraTable, Integer.MAX_VALUE);
		dijkstraTable[s] = 0;//시작정점은 0으로 설정
		pq.add(new Node(s, 0));    //가중치가 작은 노드부터 처리(처음에는 시작정점 s만들어있음)

		while (!pq.isEmpty()) {
			Node currnode = pq.poll(); //현재 최단 거리 노드 꺼냄
			if (isVisited[currnode.n])
				continue;
			isVisited[currnode.n] = true;

			for (Node node : graph[currnode.n]) {
				if (isVisited[node.n])
					continue;

				int newW = currnode.cost + node.cost;
				int originW = dijkstraTable[node.n];
				if (originW > newW) {	//기존거리보다 새로운 거리가 작으면 갱신
					dijkstraTable[node.n] = newW;
					pq.add(new Node(node.n, newW));
				}
			}

		}
	}

}