import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		ArrayDeque<Integer> deque;
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());//TC수
		while (T-- > 0) { //T번 반복하고 싶을 때 자주 쓰는 패턴
			String p = br.readLine();
			// 수행할 함수를 배열로 저장.
			int n = Integer.parseInt(br.readLine());// 배열에 들어있는 수의 갯수 n

			st = new StringTokenizer(br.readLine(), "[],");

			deque = new ArrayDeque<Integer>();

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));//배열에 갯수를 채워 넣음.
			}
			AC(p, deque);
		}
		System.out.println(sb);
	}

	static void AC(String p, ArrayDeque<Integer> deque) {
		boolean isRight = true;

		for (char cmd : p.toCharArray()) {
			if (cmd == 'R') {
				isRight = !isRight;//방향 바꾸기
				continue;
			}

			//D의 경우
			//D 함수면서 isRight가 true일 경우
			if (isRight) {

				if (deque.pollFirst() == null) {//반환된 원소가 없으면 error출력 후 함수 종료.
					sb.append("error\n");
					return;
				}
			} else {

				if (deque.pollLast() == null) {//반환된 원소가 없으면 error출력 후 함수 종료.
					sb.append("error\n");
					return;
				}
			}

		}

		//모든 함수들이 정상적으로 작동시, 덱의 남은 요소들을 출력
		makePrintString(deque, isRight);
	}

	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append('[');    //대괄호 먼저 StringBuilder에 저장

		if (deque.size() > 0) {    //출력할 원소가 1개 이상인 경우
			if (isRight) {    //정방향
				sb.append(deque.pollFirst());    //먼저 첫번쨰 원소

				//그 다음 원소부터 쉼표 출력 + 덱의 원소를 하나씩 출력.
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {                //역방향
				sb.append(deque.pollLast());    //먼저 뒤에서부터 첫 번째 원소를 넘기기.

				//그 다음 원소부터 쉼표 출력 + 덱의 원소를 뒤에서부터 하나씩 출력.
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}

		}
		sb.append(']').append('\n');	//닫는 대괄호 및 개행으로 마무리
	}

}