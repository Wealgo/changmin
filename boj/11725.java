import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.StringTokenizer;
public class Main{
	public static int n;
	public static HashMap<Integer, LinkedList<Integer>> map;
	public static int[] output;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new HashMap<>();
		output = new int[n+1];
		output[1] = 1;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			if (map.containsKey(tmp1)) {
				map.get(tmp1).add(tmp2);
			} else {
				LinkedList<Integer> list = new LinkedList<>();
				list.add(tmp2);
				map.put(tmp1, list);
			}
			if (map.containsKey(tmp2)) {
				map.get(tmp2).add(tmp1);
			} else {
				LinkedList<Integer> list = new LinkedList<>();
				list.add(tmp1);
				map.put(tmp2, list);
			}
		}
		dfs(1);
		for (int i = 2; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	public static void dfs(int p) {
		LinkedList<Integer> list = map.get(p);
		for (int i = 0; i < list.size(); i++) {
			if (output[list.get(i)] == 0) {
				output[list.get(i)] = p;
				dfs(list.get(i));
			}
		}
	}
}