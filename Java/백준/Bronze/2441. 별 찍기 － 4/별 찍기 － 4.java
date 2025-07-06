import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = N-1; i >= 0; i--) {
			for (int j = 1; j <= N; j++) {
				if(j<N-i)
                System.out.print(" ");
                else
                System.out.print("*");
			}
            System.out.println();
		}
	}
}