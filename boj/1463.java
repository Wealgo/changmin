import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(0);
			return;
		}

		LinkedList<Integer> list = new LinkedList<>();
		list.add(n);
		int output = 0;
		boolean visited[] = new boolean[1000000];
		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int tmp = list.poll();
				if (tmp == 1) {
					System.out.println(output);
					return;
				}
				if (visited[tmp] || tmp <= 0) continue;
				visited[tmp] = true;
				
				if (tmp % 3 == 0) list.add(tmp / 3);
				if (tmp % 2 == 0) list.add(tmp / 2);
				list.add(tmp - 1);
			}
			output = output + 1;
		}
	}
}