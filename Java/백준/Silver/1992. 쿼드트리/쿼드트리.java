import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] screen;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		screen = new char[N][N];

		for (int i = 0; i < N; i++) {
			screen[i] = br.readLine().toCharArray();
		}

		compass(0, 0, N);
		System.out.println(sb.toString());
		// 2. 같으면 StringBuilder에 0or1추가
		// 다르면 ( 열고 4개 영역에 대해 재귀 호출 → ) 닫기
	}

	//재귀함수 정의
	static void compass(int x, int y, int size) {
		//1.x*y 부터 size*size까지 영역이 모두 같은지 확인
		if (check(x, y, size)) {
			sb.append(screen[x][y]);
		} else {
			int half = size / 2;
			sb.append("(");
			compass(x, y, half);//1사분
			compass(x, y + half, half);//2사분
			compass(x + half, y, half);//3사분
			compass(x + half, y + half, half);//4사분
			sb.append(")");
		}
	}

	static boolean check(int x, int y, int size) {
		char first = screen[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (screen[i][j] != first)
					return false;
			}
		}
		return true;
	}
}
