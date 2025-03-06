
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());    //자료구조 개수

		int[] typeArr = new int[N];    //자료구조 배열

		StringTokenizer st = new StringTokenizer(br.readLine());

		//각 자료구조의 갯수만큼 어떤 자료구조를 가지는지 입력받기(큐or스택)
		for (int i = 0; i < N; i++) {
			typeArr[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> deque = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++){
			int num = Integer.parseInt(st.nextToken());
			if(typeArr[i]==0){
				deque.addLast(num);
			}
		}

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		br.close();

		while(M-->0){
			int moveValue = Integer.parseInt(st.nextToken());

			deque.addFirst(moveValue);
			sb.append(deque.pollLast()).append(" ");
		}
		System.out.println(sb);
	}
}
