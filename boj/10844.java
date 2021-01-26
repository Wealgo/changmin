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
		dp = new int[n+1];
		dp[1] = 9;
		System.out.println(go(n));
	}
	public static int go (int n) {
		if (n == 1) return 9;
		for (int i = 2; i <= n; i++) {
			dp[i] = ((dp[i-1]*2) - (i-1)) % 1000000000;
		}
		return dp[n];
	}
}