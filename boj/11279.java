import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author quadcore
 *
 */
public class Main {
	public static int num;
	public static PriorityQueue<Integer> pq = new PriorityQueue<>(new Desending());
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			} else pq.add(input);
		}
	}
}
class Desending implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if (o1 > o2) {
			return -1;
		} else {
			return 1;
		}
	}
	
}