import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * EZ
 * @author quadcore
 *
 */
public class Main {
	public char right = '(';
	public char left = ')';
	public String solution(String p) {
        if (p.isEmpty() || p.equals("")) {
			return "";
		}
        LinkedList<String> uandv = divide(p);
        if (isCollect(uandv.get(0))) {
			String tmp = solution(uandv.get(1));
			return uandv.get(0)+tmp;
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(solution(uandv.get(1)));
			sb.append(")");
			
			String splitU = uandv.get(0).substring(1, uandv.get(0).length()-1);
			String reverseU = "";
			for (int i = 0; i < splitU.length(); i++) {
				if (splitU.charAt(i) == right) {
					reverseU = reverseU + left;
				} else {
					reverseU = reverseU + right;
				}
			}
			sb.append(reverseU);
			return sb.toString();
		}
    }
	public LinkedList<String> divide(String s) {
		int rightCnt = 0;
		int leftCnt = 0;
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == right) {
				rightCnt++;
			} else {
				leftCnt++;
			}
			if (rightCnt == leftCnt) {
				idx = i;
				break;
			}
		}
		LinkedList<String> list = new LinkedList<>();
		String u = s.substring(0, idx+1);
		String v = s.substring(idx+1, s.length());
		list.add(u); list.add(v);
		return list;
	}
	public boolean isCollect(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == right) {
				stack.add('(');
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}