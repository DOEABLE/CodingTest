import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		find(r, c, (int)Math.pow(2, N));
        System.out.println(cnt);

	}

	public static void find(int row, int col, int size) {
		if (size == 1)
			return;
		if (row < size / 2 && col < size / 2) {//왼쪽 위
			find(row, col, size / 2);
		} else if (row < size / 2 && col >= size / 2) {//오른쪽 위칸
			cnt += (size * size / 4);
			find(row, col - size / 2, size / 2);
		} else if (row >= size / 2 && col < size / 2) {//왼쪽 아래칸
			cnt += (size * size / 4) * 2;
			find(row - size / 2, col, size / 2);
		} else {//오른쪽 아래칸
			cnt += (size * size / 4) * 3;
			find(row - size / 2, col - size / 2, size / 2);
		}
	}

}