import java.util.Stack;


/**
 * 무식하게 문자열처리 -> 시간초과
 * 스택을 활용하자!
 * @author quadcore
 *
 */
public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.solution("baabaa"));
	}

	public int solution(String s) {
		if (s.equals("")) return 1;
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.lastElement() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
        if (stack.isEmpty()) return 1;
		return 0;
    }
}