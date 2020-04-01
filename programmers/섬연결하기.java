
import java.util.PriorityQueue;

/**
 * 제발 침착하자!
 * @author quadcore
 *
 */
public class Main {

	public static void main(String[] args) {
		Main m = new Main();
//		int costs[][] = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int costs[][] = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}};
//		int costs[][] = {{0, 1, 3}, {0, 2, 4}, {1, 2, 7}, {1, 3, 3}, {2, 3, 9}};
//		int costs[][] = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}};
		System.out.println("output:"+m.solution(4, costs));
	}
	public static int n;
	public static int[][] price;
	public static boolean[][] ways;
	public static boolean visited[];
	public static int answer = 0;
	public int solution(int n, int[][] costs) {
        this.n = n;
        ways = new boolean[n][n];
        price = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < costs.length; i++) {
			ways[costs[i][0]][costs[i][1]] = true;
			ways[costs[i][1]][costs[i][0]] = true;
			price[costs[i][0]][costs[i][1]] = costs[i][2];
			price[costs[i][1]][costs[i][0]] = costs[i][2];
		}
        bfs(costs[0][0]);
        return answer;
    }
	public static void bfs(int idx) {
		PriorityQueue<Pair> list = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (!ways[idx][i]) continue;
			list.add(new Pair(idx, i, price[idx][i]));
		}
		visited[list.peek().start] = true;
		while (!list.isEmpty()) {
			Pair p = list.poll();
			if (visited[p.end]) continue;
			answer += p.cost;
			visited[p.end] = true;
			for (int i = 0; i < n; i++) {
				if (!ways[p.end][i]) continue;
				if (visited[i]) continue;
				ways[p.start][p.end] = false;
				ways[p.end][p.start] = false;
				list.add(new Pair(p.end, i, price[p.end][i]));
			}
		}
	}
}
class Pair implements Comparable<Pair> {
	int start;
	int end;
	int cost;
	public Pair(int from, int to, int cost) {
		// TODO Auto-generated constructor stub
		this.start = from;
		this.end = to;
		this.cost = cost;
	}
	public Pair(int idx, int cost) {
		// TODO Auto-generated constructor stub
		this.start = idx;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}

}