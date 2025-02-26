import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			int count = 1;
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				count = count * (entry.getValue() + 1);
			}
			sb.append(count - 1 + "\n");
		}
		System.out.println(sb);
	}
}