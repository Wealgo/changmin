import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 개-꿀!
 * @author quadcore
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) break;
			System.out.println(print(str));
		}
	}
	public static String print(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[') stack.push(str.charAt(i));
			if (str.charAt(i) == ')') {
				if (stack.isEmpty()) return "no";
				if (stack.peek() == '(') {
					stack.pop();
				} else {
					return "no";
				}
			}
			if (str.charAt(i) == ']') {
				if (stack.isEmpty()) return "no";
				if (stack.peek() == '[') {
					stack.pop();
				} else {
					return "no";
				}
			}
		}
		if (stack.size() > 0) return "no";
		return "yes";
	}
}