import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * EZ
 * @author quadcore
 *
 */
public class Main {
	public static int n;
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> list = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (list.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(list.remove());
				}
			} else {
				list.add(tmp);
			}
		}
		
	}
}