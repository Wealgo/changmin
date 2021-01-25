import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int[] dp;
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		System.out.println(go(n));
	}
	public static int go (int k) {
		if (k == 1) return 1;
		if (k == 2) return 2;
		if (k == 3) return 3;
		dp = new int[k+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] % 15746;
		}
		return dp[k];
	}
}