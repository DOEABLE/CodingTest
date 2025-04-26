import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();

		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		/**
		 *	1. 스택을 사용
		 *	2. 수열을 탐색하며 현재 원소가 이전의 원소보다 작을 때까지 stack에 수열의 index를 push
		 *	3. if 현재 원소가 스택의 top원소를 인덱스로 하는 수열의 원소보다 크게 됨
		 *	3-1	stack의 원소 pop, 해당 인덱스에 해당하는 원소들을 현재 원소로 바꿔줌.
		 */

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
				seq[stack.pop()] = seq[i];
			}

			stack.push(i);
		}

		//stack의 모든 원소를 pop 하며 해당 인덱스의 value를 -1로 초기화

		while (!stack.isEmpty()) {
			seq[stack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(seq[i]).append(' ');
		}

		System.out.println(sb);
	}
}
