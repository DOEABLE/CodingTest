import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int cost[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}

		int car[] = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			car[i] = Integer.parseInt(br.readLine());
		}

		int arr[] = new int[M + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Queue<Integer> temp = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int result = 0;

		for (int i = 0; i < 2 * M; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0) {
				if (queue.isEmpty()) {
					temp.add(num);
				} else {
					arr[num] = queue.poll();
				}
			} else {
				num = Math.abs(num);
				result += car[num] * cost[arr[num]];

				if (!temp.isEmpty()) {
					arr[temp.poll()] = arr[num];
				} else {
					queue.add(arr[num]);
				}
			}
		}
		System.out.println(result);
	}
}
