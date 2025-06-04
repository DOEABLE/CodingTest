import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int GRAY = 0;
	static int BLACK = 0;
	static int WHITE = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		//N*N 판 안에 순서대로 입력받기
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, N);

		System.out.println(GRAY);//-1
		System.out.println(BLACK);//0
		System.out.println(WHITE);//1

	}

	/*각 영역에 따라 색이 같은 색으로 이루어져있는지 검사를 하고,
		만약 같지 않다면 9개로 분할, 같다면 해당 색상의 카운트를 증가시키기.
	* */
	public static void partition(int row, int col, int size) {
		//같다면 해당 색상의 카운트를 증가
		if (colorCheck(row, col, size)) {
			if (board[row][col] == -1) {
				GRAY++;
			} else if (board[row][col] == 0) {
				BLACK++;
			} else {
				WHITE++;
			}
			return;
		}

		int newSize = size / 3;

		partition(row, col, newSize);                                //왼쪽 위
		partition(row, col + newSize, newSize);                    //중앙 위
		partition(row, col + 2 * newSize, newSize);                //오른쪽 위

		partition(row + newSize, col, newSize);                //왼쪽 중간
		partition(row + newSize, col + newSize, newSize);    //중앙 중간
		partition(row + newSize, col + 2 * newSize, newSize);//오른쪽 중간

		partition(row + 2 * newSize, col, newSize);//왼쪽 아래
		partition(row + 2 * newSize, col + newSize, newSize);//중앙 아래
		partition(row + 2 * newSize, col + 2 * newSize, newSize);//오른쪽 아래

	}

	public static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];

		//각 블럭의 시작점(row,col)부터 블럭의 끝(row+size,col+size)까지 검사
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}