import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EZ
 * @author quadcore
 *
 */
public class Main {
	public static int n;
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if (n < 10) {
			System.out.println(0);
			return;
		}
		for (int i = 10; i < n; i++) {
			if (cal(i) == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
	public static int cal(int n) {
		String tmp = Integer.toString(n);
		int cnt = n;
		for (int i = 0; i < tmp.length(); i++) {
			cnt+=((int)tmp.charAt(i)-48);
		}
		return cnt;
	}
}