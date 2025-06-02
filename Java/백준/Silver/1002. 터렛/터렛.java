import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x1, y1, r1, x2, y2, r2;
	static double d;    //중심사이의 거리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//case갯수
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
		
		d = distance(x1, y1, x2, y2);

		if (x1 == x2 && y1 == y2) {
			if (r1 == r2) {
				// System.out.println(-1);
				sb.append(-1 + " ");
			} else {
				sb.append(0 + " ");
			}
		} else {    //중심점이 다름
			if (Math.abs(r1 - r2) < d && r1 + r2 > d) { //접점갯수 2개
				sb.append(2 + " ");
			} else if ((Math.abs(r1 - r2) == d) || d == r1 + r2) {
				sb.append(1 + " ");
			} else if (d > r1 + r2 || (Math.abs(r1 - r2) > d)) {
				sb.append(0 + " ");
			}
		}
        }
		System.out.println(sb);
		br.close();

	}

	//거리 구하기
	public static double distance(int x1, int y1, int x2, int y2) {
		d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		return d;
	}
}