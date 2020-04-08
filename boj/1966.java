import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int n,idx;
	public static int answer;
	public static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken());
			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			answer = 0;
			doit();
			System.out.println(answer);
		}
    }
    public static void doit() {
    	while (!list.isEmpty()) {
			if (list.getFirst() == max()) {
				answer++;
				if (idx <= 0) return;
				idx--;
				list.poll();
			} else {
				int f = list.pollFirst();
				list.addLast(f);
				
				if (idx <= 0) {
					idx = list.size() - 1;
				} else idx--;
			}
		}
    }
    public static int max() {
    	int tmp = 0;
    	for (int i = 0; i < list.size(); i++) {
			if (tmp < list.get(i)) {
				tmp = list.get(i);
			}
		}
    	return tmp;
    }
}