import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());//한줄 전체를 읽고
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());//하나씩 꺼내기
			}
		}
		backTracking(0);
		System.out.println(result);

	}

	public static void backTracking(int depth) {
		if (depth == 3) {
			result = Math.max(result, checkSafeArea(bfs()));
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					backTracking(depth + 1);
					board[i][j] = 0;
				}
			}
		}
	}

	//4. 바이러스 확산
	static int[][] bfs() {
		int[][] newBoard = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(board[i], 0, newBoard[i], 0, M);
		}
		//바이러스(값이 2인 셀)의 위치를 BFS를 시작할 큐에 넣는다.
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newBoard[i][j] == 2) {            //바이러스 위치
					queue.add(new int[] {i, j});    //를 큐에 넣어준다.
				}
			}
		}
		/*바이러스가 현재 퍼진 위치에서 상하좌우로 전염될 수 있는 빈 칸(0)을 감염시켜서
		2로 바꾸고,
		그 좌표를 queue에 다시 넣어 연쇄적으로 확산*/
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				//범위 내이며 빈칸이면
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (newBoard[nx][ny] == 0) {
						newBoard[nx][ny] = 2;//바이러스로 감염
						queue.add(new int[] {nx, ny});//해당 위치도 이후 바이러스 감염의 시작점
					}
				}
			}
		}
		return newBoard;
	}

	public static int checkSafeArea(int[][] newBoard) {
		int safeArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (newBoard[i][j] == 0) {
					safeArea++;
				}
			}
		}
		return safeArea;
	}

}

