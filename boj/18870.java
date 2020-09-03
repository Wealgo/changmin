import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static int[] mem = new int[12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));
		HashMap<Integer, Integer> map = new HashMap<>();
		int cnt = set.size();
		for (int i = 0; i < cnt; i++) map.put(set.pollFirst(), i);
		st = new StringTokenizer(input);
		for (int i = 0; i < n; i++) {
			bw.append(map.get(Integer.parseInt(st.nextToken())) + " ");
		}
		bw.flush();
	}
}