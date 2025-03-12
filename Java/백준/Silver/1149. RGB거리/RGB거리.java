import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] homeColor;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		homeColor = new int[N][3];

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				homeColor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		//최솟값 찾기
		for (int i = 1; i < N; i++) {
			homeColor[i][0] += Math.min(homeColor[i - 1][1], homeColor[i - 1][2]);
			homeColor[i][1] += Math.min(homeColor[i - 1][0], homeColor[i - 1][2]);
			homeColor[i][2] += Math.min(homeColor[i - 1][1], homeColor[i - 1][0]);
		}
		System.out.println(Math.min(homeColor[N - 1][0], Math.min(homeColor[N - 1][1], homeColor[N - 1][2])));
	}
}