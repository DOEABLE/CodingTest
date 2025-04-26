import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//A,B의 원소의 갯수
		int n = Integer.parseInt(st.nextToken());//A의 원소
		int m = Integer.parseInt(st.nextToken());//B의 원소
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), 0);
		}
		int count = 0;
		for(int i=0; i<m;i++){
			if(map.containsKey(br.readLine())) count++;
		}
		System.out.println(count);
	}
}