import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		//여는 괄호가 나오면 무조건 스택에 넣기
		//비었을 때 닫는 괄호면 여는 괄호로 바꿔서 넣어주기
		//비어있지 않을 때 닫는 괄호라면 스택에는 무조건 여는 괄호가 있으므로 여는 괄호를 빼주기
		//이 과정을 전부 수행 후 스택에 값이 남아있다면 이는 모두 여는 괄호다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer printCount = 1;

		while (true) {
			Long operationCount = 0L;
			Stack<String> stack = new Stack<>();
			String inputString = br.readLine();

			if (inputString.indexOf('-') != -1)
				break;

			String[] strings = inputString.split("");

			for (String token : strings) {
				//Stack이 비었거는 여는 괄호 -> 스택에 넣는다.
				if (stack.isEmpty() || token.equals("{")) {
					if (token.equals("}")) {
						operationCount++;
					}
					stack.push("{");
					continue;
				}
				//닫는괄호라면
				stack.pop();
			}

			while (!stack.isEmpty()) {
				operationCount++;
				stack.pop();
				stack.pop();
			}

			System.out.println(printCount + ". " + operationCount);
			printCount++;
		}
	}
	
}