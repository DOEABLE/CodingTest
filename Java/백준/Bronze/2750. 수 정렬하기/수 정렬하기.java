import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);

		for (int num : arr) {
			System.out.println(num);
		}
	}
}