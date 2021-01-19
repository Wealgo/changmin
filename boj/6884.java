import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static ArrayList<Integer> arr;
	public static boolean[] era = new boolean[200002];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		chea();
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			for (int j = 0; j < cnt; j++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			System.out.println(go());
		}
	}
	public static String go() {
		for (int i = 2; i <= arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				int cnt = 0;
				LinkedList<Integer> result = new LinkedList<>();
				for (int k = j; k < j+i; k++) {
					cnt += arr.get(k);
					result.add(arr.get(k));
				}
				if (cnt < 2) continue;
				if (isPrimeNumber(cnt)) {
					String output = "Shortest primed subsequence is length ";
					StringBuilder sb = new StringBuilder(output);
					sb.append(result.size()+": ");
					for (int k = 0; k < result.size(); k++) {
						sb.append(result.get(k)+" ");
					}
					return sb.toString();
				}
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