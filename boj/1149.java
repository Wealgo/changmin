import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] dp, input;
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		input = new int[n+1][3];
		dp = new int[n+1][3];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmpr = Integer.parseInt(st.nextToken());
			int tmpg = Integer.parseInt(st.nextToken());
			int tmpb = Integer.parseInt(st.nextToken());
			input[i][0] = tmpr;
			input[i][1] = tmpg;
			input[i][2] = tmpb;
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i][0]  = input[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1]  = input[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2]  = input[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
