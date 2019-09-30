import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * dfs로 쉽게 풀 수 있을거라 생각하여 덤볐지만 계속된 시간 초과 발생.
 * 이유는 LinkedList와 ArrayList의 get()함수의 차이.
 * LinkedList의 get()은 O(n)의 시간복잡도를, ArrayList의 get()은 O(1)의 시간복잡도를 가진다.
 * 시간복잡도가 차이나는 이유는 LinkedListd와 ArrayList의 구조의 차이때문에 발생.
 * LinkedList와 ArrayList의 차이를 살펴보게 해준 고마운 문제.
 * @author quadcore
 *
 */
public class Main{
	public static int n,m;
	public static ArrayList<Integer> map[];
	public static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		//인접배열로 하려했으나 최대 크기가 2천개인 점을 감안하여 리스트 배열을 사용함.
		map = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			if (map[tmp1] == null) {
				map[tmp1] = new ArrayList<Integer>();
			}
			if (map[tmp2] == null) {
				map[tmp2] = new ArrayList<Integer>();
			}
			map[tmp1].add(tmp2);
			map[tmp2].add(tmp1);
		}
		for (int i = 0; i < n; i++) {
			if (dfs(i, 1)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	public static boolean dfs(int idx, int cnt) {
		if (cnt >= 5) {
			return true;
		}
		visited[idx] = true;
		for (int i = 0; i < map[idx].size(); i++) {
			int next = map[idx].get(i);
			if (visited[next]) continue;
			if (dfs(next, cnt + 1)) {
				return true;
			}
		}
		visited[idx] = false;
		return false;
	}
}