import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int white = 0;
	static int blue = 0;
	static int[][] paper;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		paper = new int[N][N];

		StringTokenizer st;
		//가로절반 세로절반. 자르기
		//파랑 칠해져있으면 1 nor 0

		//채워 일단.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, N);
        
        System.out.println(white);
		System.out.println(blue);
	}

	static boolean colorCheck(int row, int col, int size) {
		int color = paper[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				//색상이 같지 않다면 false리턴
				if (paper[i][j] != color) {
					return false;
				}
			}
		}
		return true;

	}

	static void partition(int row, int col, int size) {
		if (colorCheck(row, col, size)) {
			if (paper[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		int newSize = size / 2;

		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);
	}

}
