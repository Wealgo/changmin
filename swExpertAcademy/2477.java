import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;

/**
 * 시뮬레이션의 향연.
 */
public class Main {
	public static int n,m,k,a,b, time;
	public static LinkedList<Pair> end, repairStandby, arrived;
	public static PriorityQueue<Pair> recepStanby;	//대기큐;
	public static int [] 접수시간, 정비시간;
	public static Pair[] 접수창구, 정비창구;	//창구;
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			time = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			접수시간 = new int[n];
			정비시간 = new int[m];
			접수창구 = new Pair[n];
			정비창구 = new Pair[m];
			recepStanby = new PriorityQueue<>();
			repairStandby = new LinkedList<>();
			arrived = new LinkedList<>();
			end = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				접수시간[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				정비시간[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < k; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				Pair p = new Pair();
				p.ko = j;
				p.들어온시간 = tmp;
				arrived.add(p);
			}
			/**/
			while (is) {
				first();
				second();
				third();
			}
			for (int i = 0; i < end.size(); i++) {
				System.out.println(end.get(i).ko + ":" + end.get(i).a +":"+ end.get(i).b);
			}
		}
	}
	public static void print2() {
		for (int i = 0; i < 접수창구.length; i++) {
			if (접수창구[i] == null) continue;
			System.out.print(i + " ");
		}
		System.out.println("berepai:");
		for (int i = 0; i < repairStandby.size(); i++) {
			System.out.print(repairStandby.get(i).ko + " ");
		}
		System.out.println();
	}
	public static void first() {
		for (int i = 0; i < arrived.size(); i++) {
			if (arrived.get(i).들어온시간 == time) {
				Pair p = arrived.get(i);
				recepStanby.add(p);
			}
		}
		time++;
	}
	public static void second() {
		boolean[] visited = new boolean[30];
		for (int i = 0; i < 접수창구.length; i++) {
			if (recepStanby.isEmpty()) break;
			if (접수창구[i] != null) continue;
			Pair p = recepStanby.poll();
			p.jubCnt = 1;
			p.a = i;
			visited[i] = true;
			접수창구[i] = p;
		}
		for (int i = 0; i < 접수창구.length; i++) {
			if (접수창구[i] == null) continue;
			if (visited[i]) continue;
			접수창구[i].jubCnt++;
		}
		for (int i = 0; i < 접수창구.length; i++) {
			if (접수창구[i] == null) continue;
			if (접수창구[i].jubCnt > 접수시간[i]) {
				Pair p = 접수창구[i];
				repairStandby.add(p);
				접수창구[i] = null;
			}
		}
	}
	public static boolean is = true;
	public static void third() {
		boolean[] visited = new boolean[30];
		for (int i = 0; i < 정비창구.length; i++) {
			if (repairStandby.isEmpty()) break;
			if (정비창구[i] != null) continue;
			Pair p = repairStandby.poll();
			p.jungCnt = 1;
			p.b = i;
			visited[i] = true;
			정비창구[i] = p;
		}
		for (int i = 0; i < 정비창구.length; i++) {
			if (정비창구[i] == null) continue;
			if (visited[i]) continue;
			정비창구[i].jungCnt++;
		}
		for (int i = 0; i < 정비창구.length; i++) {
			if (정비창구[i] == null) continue;
			if (정비창구[i].jungCnt > 정비시간[i]) {
				Pair p = 정비창구[i];
				end.add(p);
				정비창구[i] = null;
			}
		}
		if (end.size() >= k) is = false;
	}
	public static boolean isRecep() {
		for (int i = 0; i < 접수창구.length; i++) {
			if (접수창구[i] == null) {
				return true;
			}
		}
		return false;
	}
}

class Pair implements Comparable<Pair>{
	int a,b;
	int ko; //고유번호
	int 들어온시간;	//들어온 시간, 도착한 시간.
	int jungCnt, jubCnt;
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.들어온시간 - o.들어온시간;
	}
}