import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * @author quadcore
 */
class Main {
	public static int n;
	public static Day[] days;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		days = new Day[n];
		
		for (int i = 0; i < days.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			days[i] = new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		visited = new boolean[n];
		backtracking(0, 0);
		System.out.println(max);
	}
	public static int max = 0;
	public static boolean[] visited;
	public static void backtracking(int idx, int totalPay) {
		if (idx > n) return;
		if (max < totalPay) max = totalPay;
		
		for (int i = idx; i < days.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			backtracking(days[i].cost + i, totalPay + days[i].pay);
			visited[i] = false;
		}
	}
}

class Day {
	int cost, pay;
	public Day(int cost, int pay) {
		// TODO Auto-generated constructor stub
		this.pay = pay;
		this.cost = cost;
	}
}
