import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//dfs
public class Main {

	static int N;
	static String s;
	static char[][] grid;
	static boolean[][] isVisited;

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());//grid한면의 길이

		grid = new char[N][N];
		isVisited = new boolean[N][N];

		int Acount = 0;
		int Bcount = 0;

		//grid(문자기반 2차원 데이터) 입력받기
		for (int i = 0; i < N; i++) {
			s = br.readLine();    //줄 바꾸기
			for (int j = 0; j < N; j++) {
				grid[i][j] = s.charAt(j);    //입력된 문자열에서 각 문자를 grid에 저장
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					dfs(i, j);
					Acount++;
				}

			}
		}

		//G=R
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}

		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					dfs(i, j);
					Bcount++;
				}
			}
		}

		System.out.println(Acount + " " + Bcount);

	}

	//같은 색이 연결된 칸을 하나의 덩어리(영역)로 세고 싶을 때
	public static void dfs(int x, int y) {
		isVisited[x][y] = true;    //현재위치 방문 처리
		char color = grid[x][y];

		for (int i = 0; i < 4; i++) {    //상하좌우 탐색루프이며 이동한 좌표를 계산
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < N && !isVisited[nx][ny]) {
				if (grid[nx][ny] == color) {    //같은 색상의 셀인가?
					//조건을 모두 만족하면 그 셀로 이동하여 DFS 계속 수행하며 탐색을 이어감.
					dfs(nx, ny);
				}
			}
		}
	}

}