import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String s = br.readLine();
			int n = s.length();
			boolean b = true;
			if (s.equals("0")) {
				break;
			}
			for (int i = 0; i <= n / 2; i++) {
				if (s.charAt(i) != s.charAt(n - i - 1)) {
					b = false;
				} 
			}
            if (b) {  //팰린드롬이면 yes 출력
                sb.append("yes\n");
            } else {  //팰린드롬이 아니면 no 출력
                sb.append("no\n");
            }
		}
        System.out.print(sb);
	}
}