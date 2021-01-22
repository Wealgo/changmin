import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static LinkedList<Integer> list = new LinkedList<>();
	public static int result = 0;
	public static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		for (int i = 0; i < size; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		list.add(0);
		list.add(0);
		go(0,0,0);
		System.out.println(result);
	}
	public static void go(int stage, int chain, int score) {
		if (chain >= 3) return;
		if (stage > size) return;
		if (stage == size) result = Math.max(result, score+list.getLast());
		int _score = score + list.get(stage);
		go(stage+1, chain+1, _score);
		go(stage+2, 0, _score);
	}
}
