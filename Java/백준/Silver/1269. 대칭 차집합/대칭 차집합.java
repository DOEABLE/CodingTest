import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//A,B의 원소의 갯수
		int A = Integer.parseInt(st.nextToken());//A의 원소
		int B = Integer.parseInt(st.nextToken());//B의 원소
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			setB.add(Integer.parseInt(st.nextToken()));
		}

		int answer = 0;
		for (int num : setA) {
			if (!setB.contains(num)) {
				answer += 1;
			}
		}
		for (int num : setB) {
			if (!setA.contains(num)) {
				answer += 1;
			}
		}
		System.out.println(answer);
	}
}