import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Not EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long[] dp=new long[input.length()+1];
		dp[0] = dp[1] = 1;
		if(input.charAt(0)=='0'){
			System.out.println(0);
		    return;
		}
		for(int i = 1; i < input.length(); i++) {
			char pri = input.charAt(i - 1);
		    if(input.charAt(i) >= '1' && input.charAt(i)<='9') {
		    	dp[i+1]+=dp[i];
		        dp[i+1]%=1000000;
		    }
		    if (!(pri == '0' || pri > '2' || (pri == '2' && input.charAt(i) > '6'))) {
		    	dp[i + 1] += dp[i-1];
		    	dp[i+1]%=1000000;
		    }
		    dp[i + 1] %= 1000000000;
		 }
		 System.out.println(dp[input.length()]%1000000000);
	}
}