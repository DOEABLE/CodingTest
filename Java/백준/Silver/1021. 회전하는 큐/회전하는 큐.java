import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static LinkedList<Integer> queue = new LinkedList<>();//입력받은 수 저장공간
	static int[] getArr;//뽑을 숫자들을 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//1.맨 앞 원소[0]를 빼낸다.

		//3. 오른쪽으로 한 칸 이동 맨뒤거 빼서 맨 앞에 두고

		int N = Integer.parseInt(st.nextToken());//큐의 크기
		int M = Integer.parseInt(st.nextToken());//뽑아낼 갯수

		//큐에 1부터 N까지 담아두기(offer)
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		st = new StringTokenizer(br.readLine());

		getArr = new int[M];

		//뽑을 수를 배열에 저장
		for (int i = 0; i < M; i++) {
			getArr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		System.out.println(solution(M));
	}

	//최소 비용을 구하는 매서드
	static int solution(int M) {
		int cost = 0;

		for (int i = 0; i < M; i++) {
			//찾으려는 숫자의 인덱스 값을 넣기
			int targetIndex = queue.indexOf(getArr[i]);
			int midIndex;

			//큐의 사이즈
			if (queue.size() % 2 == 0) {
				//인덱스틑 0부터 시작하므로 -1
				midIndex = queue.size() / 2 - 1;
			} else {
				midIndex = queue.size() / 2;
			}

			//2. 중간지점이거나 중간보다 앞에 있는 경우(왼쪽으로 한 칸 이동. 빼낸 원소는 냅두기)
			if (targetIndex <= midIndex) {
				for (int j = 0; j < targetIndex; j++) {
					//찾으려는 숫자의 인덱스보다 앞에있는 원소들을 모두 뒤로 보내기
					int tmp = queue.pollFirst();
					queue.offerLast(tmp);
					cost++;//2,3번은 연산 증가.
				}
			}

			//3. 중간보다 뒤에 있는 경우(왼쪽으로 한 칸 이동. 빼낸 원소는 냅두기)
			else {
				for (int j = 0; j < queue.size() - targetIndex; j++) {
					//찾으려는 숫자의 인덱스보다 앞에있는 원소들을 모두 앞으로 보내기
					int tmp = queue.pollLast();
					queue.offerFirst(tmp);
					cost++;//2,3번은 연산 증가.
				}
			}
			//모든 수행이 끝나면 가장 앞에 뽑으려는 숫자가 존재하므로 1번연산으로 뽑아버림
			queue.pollFirst();
		}
		return cost;
	}

}