import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<int[]> queue;    //(초기 인덱스 값, 중요도)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TestCase = Integer.parseInt(br.readLine());

		while (TestCase-- > 0) {
			queue = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());    //문서의 갯수
			int M = Integer.parseInt(st.nextToken());    //M번째 문서는 몇번째로 뽑혔는가
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			//중요도 확인
			sb.append(solution(M)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	//M번째문서가 출력되는 순서
	static int solution(int M) {
		int findItem = 0;

		while (!queue.isEmpty()) {
			int[] first = queue.poll();
			boolean isMax = true; //해당 요소의 중요성이 가장 큰가 판별

			//큐에 남아있는 모든 요소들과 반복문을 돌려 중요도 비교
			for (int i = 0; i < queue.size(); i++) {
				if (first[1] < queue.get(i)[1]) {
					queue.offer(first);

					for (int j = 0; j < i; j++) {
						queue.offer(queue.poll());
					}
					isMax = false;    //first(해당 뽑은 요소)보다 큰 요소가 있다.
					break;            //반복문을 나옴.
				}
			}
			if (isMax == false) {
				continue;
			}
			findItem++;

			if (first[0] == M) {
				break;
			}
		}
		return findItem;
	}
}