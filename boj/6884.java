import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int[] array;
	public static boolean[] era = new boolean[200002];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		chea();
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			array = new int[cnt];
			for (int j = 0; j < cnt; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				array[j] = tmp;
			}
			System.out.println(go());
		}
	}
	public static String go() {
		for (int i = 2; i < array.length; i++) {
			int j = 0;
			while (j + i <= array.length) {
				int cnt = 0;
				LinkedList<Integer> list = new LinkedList<>();
				for (int k = j; k < j+i; k++) {
					cnt += array[k];
					list.add(array[k]);
				}
				j++;
				if (!isPrimeNumber(cnt)) continue;
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < list.size(); k++) {
					sb.append(" "+list.get(k));
				}
				return "Shortest primed subsequence is length "+list.size()+":"+sb.toString();
			}
		}
		return "This sequence is anti-primed.";
	}
	public static boolean isPrimeNumber(int input) {
		if (!era[input]) {
			return true;
		}
		return false;
	}
	public static void chea() {
		for (int i = 2; i < era.length-1; i++) {
			if (!era[i]) {
				for (int j = 2; j*i < era.length-1; j++) {
					era[i*j] = true;
				}
			}
		}
	}
}