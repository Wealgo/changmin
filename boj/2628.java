import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<Integer> garist = new LinkedList<>();
	public static LinkedList<Integer> selist = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sero = Integer.parseInt(st.nextToken());
		int garo = Integer.parseInt(st.nextToken());
		selist.add(sero);
		garist.add(garo);
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gase = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (gase == 1) {
				selist.add(idx);
			} else {
				garist.add(idx);
			}
		}
		Collections.sort(garist);
		Collections.sort(selist);
		LinkedList<Integer> ngaro = new LinkedList<>();
		LinkedList<Integer> nsero = new LinkedList<>();
		
		int cnt = 0;
		for (int i = 0; i < garo; i++) {
			if (i == garist.getFirst()) {
				ngaro.add(cnt);
				cnt = 0;
				garist.removeFirst();
			}
			cnt++;
		}
		ngaro.add(cnt);
		cnt = 0;
		for (int i = 0; i < sero; i++) {
			if (i == selist.getFirst()) {
				nsero.add(cnt);
				cnt = 0;
				selist.removeFirst();
			}
			cnt++;
		}
		nsero.add(cnt);
		Collections.sort(ngaro);
		Collections.sort(nsero);
		System.out.println(ngaro.getLast() * nsero.getLast());
	}
}
