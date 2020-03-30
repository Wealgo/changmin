import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 더 좋은 풀이.
 * @author quadcore
 *
 */
public class Main {
	public static int n,k;
	public static int[] coins;
	public static int output = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		for (int i = coins.length-1; i >= 0; i--) {
			if (k >= coins[i]) {
				output += k/coins[i];
				k = k%coins[i];
			}
		}
		System.out.println(output);
	}

}