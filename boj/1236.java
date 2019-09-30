import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 꽤나 머리 썩었던 문제.
 * 각각의 상황으로 답을 도출하는 귀납적으로 풀었음.
 * @author quadcore
 *
 */
public class Main{
	public static int n,m;
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		boolean[] garo = new boolean[m];
		boolean[] sero = new boolean[n];
		map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				if (tmp.charAt(j) == 'X') {
					map[i][j] = true;
				}
			}
		}
		for (int i = 0; i < sero.length; i++) {
			for (int j = 0; j < garo.length; j++) {
				if (map[i][j]) {
					garo[j] = true;
					sero[i] = true;
				}
			}
		}
		int output1 = 0;
		int output2 = 0;
		for (int i = 0; i < sero.length; i++) {
			if (!sero[i]) {
				output1 = output1 + 1;
			}
		}
		for (int i = 0; i < garo.length; i++) {
			if (!garo[i]) {
				output2 = output2 + 1;
			}
		}
		if (output1 < output2) {
			System.out.println(output2);
		} else {
			System.out.println(output1);
		}
	}
}