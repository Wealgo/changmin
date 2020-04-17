import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 어렵지 않은 문제.
 */
public class Main {
	public static int n,k;
	public static int han;
	public static TreeSet<Integer> set = new TreeSet<>();
	public static LinkedList<Character> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			han = n/4;
			String t = br.readLine();
			list = new LinkedList<>();
			set = new TreeSet<>();
			for (int j = 0; j < t.length(); j++) {
				list.add(t.charAt(j));
			}
			for (int j = 0; j < n/4; j++) {
				chu(list);
				char tmp = list.pollFirst();
				list.addLast(tmp);
			}
			LinkedList<Integer> output = new LinkedList<>();
			int cnt = set.size();
			for (int j = 0; j < cnt; j++) {
				output.add(set.pollFirst());
			}
			Collections.sort(output);
			Collections.reverse(output);
			System.out.println("#"+(i+1)+" "+output.get(k-1));
		}
	}
	public static void chu(LinkedList<Character> list) {
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			if ((i%han) == 0) {
				String tmp = sb.toString();
				set.add(Integer.parseInt(tmp, 16));
				sb = new StringBuilder();
				sb.append(list.get(i));
			} else {
				sb.append(list.get(i));
			}
		}
		set.add(Integer.parseInt(sb.toString(), 16));
	}
}