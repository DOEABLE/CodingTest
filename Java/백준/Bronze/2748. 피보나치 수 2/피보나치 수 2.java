import java.io.IOException;
import java.util.Scanner;

public class Main {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		arr = new long[size+1];
		for (int i = 0; i < size+1; i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		arr[1] = 1;

		System.out.println(fibonacci(size));
	}

	public static long fibonacci(int size) {
		if (arr[size] == -1) {
			arr[size] = fibonacci(size - 1) + fibonacci(size - 2);
		}
		return arr[size];
	}
}