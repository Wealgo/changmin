
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 *
 */
public class Main {
	public static String a;
	public static String b;
	public static int diff;
	public static int output = 999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = st.nextToken();
		b = st.nextToken();
		diff = b.length() - a.length();
		for (int i = 0; i <= diff; i++) {
			int cnt = 0;
			for (int j = 0; j < a.length(); j++) {
				if (b.charAt(j+i) != a.charAt(j)) cnt++;
			}
			if (output > cnt) output = cnt;
		}
		System.out.println(output);
	}
}