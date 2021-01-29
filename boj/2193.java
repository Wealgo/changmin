import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[91];
		System.out.println(go(n));
	}
	public static long go(int cnt) {
		if (cnt == 1 || cnt == 2) return 1;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= cnt; i++) {
			dp[i] = dp[i-1] + dp[i - 2];
		}
		return dp[cnt];
	}
}