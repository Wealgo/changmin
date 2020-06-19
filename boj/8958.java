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
	public static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			answer = 0;
			int tmp = 0;
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == 'O') tmp++;
				else tmp = 0;
				answer += tmp;
			}
			System.out.println(answer);
		}
	}
}