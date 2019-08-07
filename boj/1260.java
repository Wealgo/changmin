import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] visited;
	public static boolean[][] map;
	public static int jungjum;
	public static int gansun;
	public static LinkedList<Integer> dfs = new LinkedList<Integer>();
	public static LinkedList<Integer> bfs = new LinkedList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		jungjum = Integer.parseInt(st.nextToken());
		gansun = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken())-1;
		visited = new boolean[jungjum];
		map = new boolean[jungjum][jungjum];
		for (int i = 0; i < gansun; i++) {
			st = new StringTokenizer(sc.nextLine());
			int tmp1 = Integer.parseInt(st.nextToken())-1;
			int tmp2 = Integer.parseInt(st.nextToken())-1;
			map[tmp1][tmp2] = true;
			map[tmp2][tmp1] = true;
		}
		dfs(start);
		visited = new boolean[jungjum];
		bfs(start);
		for (int i = 0; i < dfs.size(); i++) {
			System.out.print((dfs.get(i)+1)+" ");
		}
		System.out.println();
		for (int i = 0; i < bfs.size(); i++) {
			System.out.print((bfs.get(i)+1)+" ");
		}
	}
	public static void dfs(int next) {
		visited[next] = true;
		dfs.add(next);
		for (int i = 0; i < map.length; i++) {
			if (map[next][i] == true && visited[i] == false) {
				dfs(i);
			}
		}
	}
	public static void bfs(int next) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(next);
		visited[next] = true;
		bfs.add(next);
		while (!list.isEmpty()) {
			int tmp = list.pollFirst();
			
			for (int i = 0; i < map.length; i++) {
				if (map[tmp][i] == true && visited[i] == false) {
					list.add(i);
					bfs.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
