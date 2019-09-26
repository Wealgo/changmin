import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 문제의 출력 형식을 제대로 읽지 않아 20개씩 짤라 출력하지 않음
 * 3시간 소비함.
 * 문제좀 똑바로 읽자.
 * @author quadcore
 *
 */
public class Main{
	public static int n;
	public static boolean[] swich;
	public static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		swich = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			String tmp = st.nextToken();
			if (tmp.equals("1")) {
				swich[i] = true;
			}
		}
		int students = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < students; i++) {
			st = new StringTokenizer(sc.nextLine());
			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (sex == 1) {
				male(idx);
			} else {
				female(idx);
			}
		}
		for (int i = 1; i < swich.length; i++) {
			if (swich[i]) {
				System.out.print(1+" ");
			} else {
				System.out.print(0+" ");
			}
			if (i%20 == 0) {
				System.out.println();
			}
		}
	}
	public static void male(int idx) {
		for (int i = 0; i < swich.length; i+=idx) {
			if (i == 0) {
				continue;
			}
			if (swich[i]) {
				swich[i] = false;
			} else {
				swich[i] = true;
			}
		}
	}
	public static void female(int idx) {
		int pl = idx;
		int mi = idx;
		for (int i = 0; i < swich.length-1; i++) {
			if (idx + i <= n && idx - i >= 1) {
				if (swich[idx + i] == swich[idx - i]) {
					pl = idx + i;
					mi = idx - i;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		System.out.println(mi + ":" + pl);
		for (int i = mi; i <= pl; i++) {
			if (swich[i]) {
				swich[i] = false;
			} else {
				swich[i] = true;
			}
		}
	}
}