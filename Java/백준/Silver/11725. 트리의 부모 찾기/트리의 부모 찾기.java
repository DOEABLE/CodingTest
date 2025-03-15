import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//인접 리스트 생성 및 초기화
	static List<List<Integer>> adjList;
	static int N;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringTokenizer st = receiveInput(br);
        N = parseInt(st.nextToken());

		adjList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			// adjList에 각 노드 연결 정보 추가
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = receiveInput(br);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		//1번 노드부터 부모노드를 찾아 매핑
		parents = new int[N + 1];
		// (단, 이미 탐색한 노드는 재방문 하지 않도록.)
		visited = new boolean[N + 1];

		DFS(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}

	}

	static void DFS(int currentNode) {
		//현재 노드 방문처리
		visited[currentNode] = true;
		//인접 린스트 순회
		for (int adjacent : adjList.get(currentNode)) {
			if (!visited[adjacent]) {
				parents[adjacent] = currentNode;
				DFS(adjacent);
			}
		}
	}

	static StringTokenizer receiveInput(BufferedReader br) throws IOException {
		return new StringTokenizer(br.readLine());
	}
}