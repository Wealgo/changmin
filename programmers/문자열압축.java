import java.io.IOException;

/**
 * 분발하자.
 * @author quadcore
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		System.out.println(m.solution("aabbaccc"));
	}

	public int recursive(String input, String check, int cnt, int num, String output) {
		int result = 0;
		if (input.length() < num) {
			StringBuilder sb = new StringBuilder(output);
			if (cnt > 1) sb.append(cnt);
			sb.append(check);
			sb.append(input);
			return sb.toString().length();
		}
		
		String str = input.substring(0, num);
		if (str.equals(check)) {
			result = recursive(input.substring(num), str, cnt+1, num, output);
		} else {
			StringBuilder sb = new StringBuilder(output);
			if (cnt > 1) {
				sb.append(cnt);
			}
			sb.append(check);
			result = recursive(input.substring(num), str, 1, num, sb.toString());
		}
		return result;
	}
	
	public int solution(String s) {
        int answer = 999999;
        for (int i = 1; i < s.length()/2+2; i++) {
			int tmp = recursive(s.substring(i), s.substring(0, i), 1, i, "");
			if (tmp < answer) {
				answer = tmp;
			}
		}
        return answer;
    }
}
