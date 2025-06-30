import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// for (int i = 1; i <= 1; i++) {
		// 	System.out.print("*");
		// }
		// System.out.println();
		//
		// for (int i = 1; i <= 2; i++) {
		// 	System.out.print("*");
		// }
		// System.out.println();
		//
		// for (int i = 1; i <= 3; i++) {
		// 	System.out.print("*");
		// }
		// System.out.println();
		//
		// for (int i = 1; i <= 4; i++) {
		// 	System.out.print("*");
		// }
		// System.out.println();
		//
		// for (int i = 1; i <= 5; i++) {
		// 	System.out.print("*");
		// }
		// System.out.println();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}