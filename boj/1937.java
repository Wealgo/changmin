import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n, max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] map = new int[10001];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[d] = Math.max(map[d], p);
		}
//		for (int i = 10000; i > 0; i--) {
//			if (map[i] == 0) continue;
//			System.out.print(map[i]+" ");
//		}
		int output = 0;
		for (int i = 10000; i >= 0; i--) {
			output += map[i];
		}
		System.out.println(output);
	}
}
