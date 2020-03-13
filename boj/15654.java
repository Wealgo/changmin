import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 머리 물렁하게 만들자.
 * @author quadcore
 *
 */
public class Main {
	public static int output;
	public static int n,m;
	public static LinkedList<Integer> arr;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		arr = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		LinkedList<Integer> list = new LinkedList<>();
		recursive(list);
	}
	
	public static void recursive(LinkedList<Integer> list) {
		if (list.size() == m) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			list.add(arr.get(i));
			visited[i] = true;
			recursive(list);
			list.removeLast();
			visited[i] = false;
		}
	}
	
}
