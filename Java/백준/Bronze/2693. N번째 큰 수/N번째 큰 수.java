import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < test; i++) {
			int[] arr = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			sb.append(arr[7] + "\n");
		}
		System.out.println(sb);
	}
}