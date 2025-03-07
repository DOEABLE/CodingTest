import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int res = 0;
		int[] time = new int[N];
		String arr = br.readLine();
		StringTokenizer st = new StringTokenizer(arr, " ");

		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				res += time[j];
			}
		}
		System.out.print(res);
	}
}