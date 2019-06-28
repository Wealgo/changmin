import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 시간초과가 발생.
 * 시간복잡도 계산을 먼저 해보자.
 * 제한시간은 0.5
 * 각 테스트케이스당 최대 도시락과 사람의 수는 1만.
 * wjdfuf()은 선택정렬로 구현했으니 n^2.
 * 최악의 테스트케이스의 경우 대략 1초 걸림.
 * 가장 시간을 많이 잡아먹는 부분이 wjdfuf()이라 예상한다.
 * 아니면 hap()이놈도 문제.
 */
public class Main{
	public static LinkedList<Integer> hot = new LinkedList<>();
	public static LinkedList<Integer> eat = new LinkedList<>();
	public static int time = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int k = 0; k < testcase; k++) {
			int n = sc.nextInt();
			
			for (int j = 0; j < n; j++) {
				hot.add(sc.nextInt());
			}
			for (int j = 0; j < n; j++) {
				eat.add(sc.nextInt());
			}
			wjdfuf();
			System.out.println(time());
			hot = new LinkedList<>();
			eat = new LinkedList<>();
			time = 0;
		}

	}
	public static void wjdfuf() {
		for (int i = 0; i < eat.size(); i++) {
			int which = i;
			for (int j = i+1; j < eat.size(); j++) {
				if (eat.get(which) <= eat.get(j)) {
					which = j;
				}
			}
			Collections.swap(eat, i, which);
			Collections.swap(hot, i, which);
		}
	}
	public static int time() {
		LinkedList<Integer> list = new LinkedList<>();
		int tmp = 0;
		for (int i = 0; i < hot.size(); i++) {
			tmp = hot.get(i) + tmp;
			list.add(tmp + eat.get(i));
		}
		Collections.sort(list);
		return list.getLast();
	}
	public static int hap(int n) {
		int output = 0;
		for (int i = 0; i <= n-1; i++) {
			output = output + hot.get(i);
		}
		return output;		
	}
}