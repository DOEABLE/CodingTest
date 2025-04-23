import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] words;
	static List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//공백을 두고 한줄로 입력된 여러 숫자를 입력 받음.
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		words = br.readLine().split(" ");
		Arrays.sort(words);

		for (int i = 0; i < C; i++) {
			List<String> list = new ArrayList<>();
			list.add(words[i]);
			backTrack(list, i);
		}

	}

	public static void backTrack(List<String> arr, int index) {
		if (arr.size() == L) {
			if (check(arr)) {
				System.out.println(String.join("", arr));
			}
			return;
		}

		for (int i = index + 1; i < C; i++) {

			if (arr.get(arr.size() - 1).compareTo(words[i]) < 0) {
				arr.add(words[i]);
				backTrack(arr, i);
				arr.remove(arr.size() - 1);
			}
		}
	}

	public static boolean check(List<String> arr) {
		int vCount = 0, cCount = 0;
		for (String ch : arr) {
			if (vowel.contains(ch.charAt(0))) {
				vCount++;
			} else {
				cCount++;
			}
		}
		return vCount >= 1 && cCount >= 2;
	}
}