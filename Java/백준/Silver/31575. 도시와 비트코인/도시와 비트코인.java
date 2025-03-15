import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;//2차원 공간일 때 가로, 세로 크기
	static int[][] map; //2차원 공간인 도시
	//어딘가 좌표로 움직여야할때
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");// 공백으로 구분해 문자열을 가져옴.

		//가로, 세로 크기 숫자 받음.(문자열을 int로 변환)
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(BFS());
	}

	private static String BFS() {
		Queue<int[]> queue = new LinkedList<>();//정수배열을 저장하는 queue 생성
		queue.offer(new int[] {1, 1});//길이가 2인 정수 배열{1,1}삽입하여 큐 생성
		boolean[][] visited = new boolean[M + 1][N + 1];
		visited[1][1] = true;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			if (p[0] == M && p[1] == N)
				return "Yes";

			for (int i = 0; i < 2; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];

				if (nx <= M && ny <= N && map[nx][ny] == 1 & !visited[nx][ny]) {
					queue.offer(new int[]{nx,ny});
					visited[nx][ny]=true;
				}
			}
		}
		return "No";
	}
}
