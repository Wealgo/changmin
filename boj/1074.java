import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static int r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		n = (int) Math.pow(2, tmp);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		devide(0, 0, n);
		System.out.println(cnt);
	}
	public static int cnt = 0;
	public static boolean isStop = false;
	public static void devide(int y, int x, int len) {
		if (isStop) return;
		if (len == 2) {
			if (y == r && x == c) {
				isStop = true;
				return;
			} else cnt++;
			if (y == r && x+1 == c) {
				isStop = true;
				return;
			} else cnt++;
			if (y+1 == r && x == c) {
				isStop = true;
				return;
			} else cnt++;
			if (y+1 == r && x+1 == c) { 
				isStop = true;
				return;
			} else cnt++;
			return;
		} else {
			devide(y, x, len/2);
			devide(y, x+(len/2), len/2);
			devide(y+(len/2), x, len/2);
			devide(y+(len/2), x+(len/2), len/2);
		}
	}
}