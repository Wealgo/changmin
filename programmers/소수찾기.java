import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		String numbers = "011";
		System.out.println(m.solution(numbers));
	}
	public int answer;
	public String numbers;
	public boolean visited[];
	public int solution(String numbers) {
		this.numbers = numbers;
		this.visited = new boolean[numbers.length()];
		this.nVisited = new boolean[10000000];
	    for (int i = 0; i < numbers.length()+1; i++) {
			backtracking(0, i, "");
		}
	    return answer;
	}
	
	public void backtracking(int idx, int cnt, String n) {
		if (cnt == 0) {
			check(n);
			return;
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (visited[i]) continue;
			visited[i] = true;
			StringBuilder sb = new StringBuilder(n);
			sb.append(numbers.charAt(i));
			backtracking(i, cnt-1, sb.toString());
			visited[i] = false;
		}
	}
	public boolean[] nVisited;
	public void check(String input) {
		if (input.isEmpty() || input.equals("")) return;
		int tmp = Integer.parseInt(input);
		if (nVisited[tmp] || tmp == 1 || tmp == 0) return;
		for (int i = 2; i < tmp-1; i++) {
			if (tmp%i == 0) return;
		}
		nVisited[tmp] = true;
		System.out.println("t:"+input);
		answer++;
	}
}