import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n, output = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) checker(br.readLine());	
		System.out.println(output);
	}
	public static void checker(String input) {
		boolean[] visited = new boolean[130];
		char tmp = input.charAt(0);
		visited[tmp] = true;
		for (int i = 1; i < input.length(); i++) {
			if (tmp == input.charAt(i)) continue;
			tmp = input.charAt(i);
			if (visited[tmp]) return;
			visited[tmp] = true;
		}
		output++;
	}
}