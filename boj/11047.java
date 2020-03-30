import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 침착하자.
 * @author quadcore
 *
 */
public class Main {
	public static int n,k;
	public static int[] coins;
	public static int output = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		while (0 != k) {
			for (int i = coins.length-1; i >= 0; i--) {
				if (k < coins[i]) continue;
				k = k - coins[i];
				++output;
				break;
			}
		}
		System.out.println(output);
	}

}