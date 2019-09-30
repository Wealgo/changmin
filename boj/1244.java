import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 문제를 차근히 읽자.
 * 여학생의 경우 "좌우가 대칭이면서 가장 많은 구간을 포함하는 구간"의 이해를 잘못함.
 * 크게 어려운 문제는 아니었지만 문제의 명시가 애매해서 시간을 많이 잡아먹음.
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
	//남학생인 경우~
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
	//여학생인 경우~
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
		for (int i = mi; i <= pl; i++) {
			if (swich[i]) {
				swich[i] = false;
			} else {
				swich[i] = true;
			}
		}
	}
}