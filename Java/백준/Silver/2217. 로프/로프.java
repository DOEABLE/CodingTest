import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		
		for(int i =0;i<N;i++){
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		
		int max = Integer.MIN_VALUE;
		for(int k =0; k<N; k++){
			max=Math.max(max,rope[k]*(N-k));
		}
		System.out.println(max);
	}
}
