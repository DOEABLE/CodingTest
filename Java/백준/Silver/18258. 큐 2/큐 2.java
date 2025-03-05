import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		int keep = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String now = st.nextToken();
			if (now.equals("push")) {
				int a = Integer.parseInt(st.nextToken());
				queue.offer(a);
				keep = a;
			} else if (now.equals("pop")) {
				if (queue.isEmpty() == false) {
					int k = queue.poll();
					sb.append(k).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if (now.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (now.equals("empty")) {
				if (queue.isEmpty() == true) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (now.equals("front")) {
				if (queue.isEmpty() == false) {
					sb.append(queue.peek()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			} else if (now.equals("back")) {
				if (queue.isEmpty() == false) {
					sb.append(keep).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}