import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int n, m, k;
	public static int[][] a, b;
	public static long[][] result;
	public static LinkedList<Integer> dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) a[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		st.nextElement();
		k = Integer.parseInt(st.nextToken());
		b = new int[m][k];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) b[i][j] = Integer.parseInt(st.nextToken());
		}
		result = new long[n][k];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) System.out.print(a[i][j]+" ");
			System.out.println();
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) System.out.print(b[i][j]+" ");
			System.out.println();
		}
		go();
		System.out.println("<>");
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) System.out.print(result[i][j]+" ");
			System.out.println();
		}
	}
	public static void go() {
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = multi(i, j);
			}
		}
	}
	public static long multi(int y, int x) {
		long tmp = 0;
		for (int i = 0; i < m; i++) {
			tmp += a[y][i]*b[i][x];
		}
		return tmp;
	}
}