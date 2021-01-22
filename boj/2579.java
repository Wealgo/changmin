import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int result = 0;
	public static int size;
	public static int[] stair, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		dp = new int[301];
		stair = new int[301];
//		for (int i = 0; i < dp.length; i++) dp[i] = -1;
		
		for (int i = 1; i <= size; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];
		dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		for (int i = 4; i <= size; i++) {
			dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i] + stair[i-1]);
		}
		System.out.println(dp[size]);
	}
	
}
