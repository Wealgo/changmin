import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int v,e;
	public static int start;
	public static ArrayList<Pair>[] map;
	public static int[] output;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		output = new int[v];
		map = new ArrayList[v];
		visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			output[i] = 999999;
			map[i] = new ArrayList<Pair>();
		}
		
		start = Integer.parseInt(br.readLine())-1;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map[u].add(new Pair(v, w));
		}
		go();
		for (int i = 0; i < output.length; i++) {
			if (output[i] == 999999) {
				bw.append("INF\n");
			} else {
				bw.append(output[i]+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void go() {
		output[start] = 0;
		PriorityQueue<Pair> list = new PriorityQueue<>();
		list.add(new Pair(start, 0));
		while (!list.isEmpty()) {
			Pair p = list.poll();
			int s = p.p;
			if (visited[s]) continue;
			visited[s] = true;
			for (int i = 0; i < map[s].size(); i++) {
				//갈 수 있는 간선 중 최소값이면 넣어
				Pair tmp = map[s].get(i);
				int ne = tmp.p;
				int nw = tmp.w;
				if (output[ne] > output[s] + nw) {
					output[ne] = output[s] + nw;
					list.add(new Pair(ne, output[s] + nw));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	//w는 가중치, p는 위치.
	int w, p;
	public Pair(int p, int w) {
		// TODO Auto-generated constructor stub
		this.p = p;
		this.w = w;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.w - o.w;
	}
}