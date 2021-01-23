import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int[][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[21][21][21];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			st = null;
			if (a == -1 && b == -1 && c == -1) return;
			String sb = "w("+a+", "+b+", "+c+") = "+w(a,b,c);
			System.out.println(sb);
		}
	}
	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
		if (dp[a][b][c] == 0) {
			if (a < b && b < c) {
				dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
				return dp[a][b][c];
			} else {
				dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
				return dp[a][b][c];
			}
		} else return dp[a][b][c];
	}
}
