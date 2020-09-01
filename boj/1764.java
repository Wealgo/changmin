import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			set.add(str);
		}
		LinkedList<String> output = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				output.add(str);
			}
		}
		System.out.println(output.size());
		Collections.sort(output);
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
	}
}