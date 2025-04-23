import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int[][] board;
	static Deque<int[]> snake = new LinkedList<>();//뱀의 몸 시뮬레이션
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	//시간 별 방향 전환
	static HashMap<Integer, Character> directionMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		int K = Integer.parseInt(br.readLine());//사과 갯수
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			board[x][y] = 1;    //사과위치는 1로 표시
		}

		int L = Integer.parseInt(br.readLine());//방향전환 횟수
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			directionMap.put(time, dir);
		}
		System.out.println(simulate());
	}

	public static int simulate() {
		int time = 0;
		int dir = 0;//처음방향: 오른쪽
		int x = 0, y = 0;
		snake.add(new int[] {x, y});
		board[x][y] = 2;//뱀의 몸: 2

		while (true) {
			time++;

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			//벽이나 자신의 몸에 닿으면 게임 종료
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2)
				break;

			if (board[nx][ny] == 1) { // 사과가 있는 경우
				board[nx][ny] = 2;
				snake.addFirst(new int[] {nx, ny});
				// 꼬리 유지 (몸 길어짐)
			} else { // 사과 없는 경우
				board[nx][ny] = 2;
				snake.addFirst(new int[] {nx, ny});
				int[] tail = snake.removeLast();
				board[tail[0]][tail[1]] = 0; // 꼬리 제거
			}

			//방향전환
			if (directionMap.containsKey(time)) {
				char c = directionMap.get(time);
				if (c == 'D') {
					dir = (dir + 1) % 4;//오른쪽 회전
				} else {
					dir = (dir + 3) % 4;//왼쪽 회전
				}
			}
			x = nx;
			y = ny;
		}
		return time;
	}

}