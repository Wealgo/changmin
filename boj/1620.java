import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 오래전에 틀렸던 문제.
 */
public class Main {
	public static int n,m;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			map1.put(i, str);
			map2.put(str, i);
		}
		LinkedList<String> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			try {
				int idx = Integer.parseInt(str);
				System.out.println(map1.get(idx));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(map2.get(str));
			}
		}
	}
}