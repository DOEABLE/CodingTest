import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		//스택만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		//덱, 큐 이용
		Deque<Integer> deque = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();

		for(int i =1;i<=n;i++){
			deque.addLast(i);
		}
		//카드가 1장이 될 때까지
		while (deque.size() > 1) {
			//[0]버리기(버릴 스택만들기)
			queue.add(deque.removeFirst());
			deque.addLast(deque.removeFirst());//[1]덱 맨밑으로
		}
		StringBuilder sb = new StringBuilder();
		for(int i:queue){
			sb.append(i+" ");
		}
		sb.append(deque.remove());
		System.out.print(sb);
	}
}