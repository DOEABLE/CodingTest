import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}
		boolean[] visited = new boolean[100001];
		visited[N] = true;        //현재 노드를 방문했다는 플래그

		//Queue에 N을 넣고
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		int size;
		int count = 0;

		while (true) {
			count++;
			size = queue.size();
			for (int i = 0; i < size; i++) {
				int x = queue.remove();
				visited[x] = true;

				if (x - 1 == K || x + 1 == K || x * 2 == K) {
					System.out.println(count);
					return;
				}
				if (x - 1 >= 0 && !visited[x - 1]) {
					visited[x-1]=true;
					queue.add(x-1);
				}
				if(x+1<=100000 && !visited[x+1]){
					visited[x+1]=true;
					queue.add(x+1);
				}
				if(x*2<=100000 && !visited[x*2]){
					visited[x*2]=true;
					queue.add(x*2);
				}
			}
		}

	}
}