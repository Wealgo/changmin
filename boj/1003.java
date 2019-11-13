import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 오래전에 틀렸던 문제.
 */
public class Main {
	public static int n;
	public static int n1,n2;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());
			visited1 = new int[n+1];
			visited0 = new int[n+1];
			n1 = 0; n2 = 0;
			pibo(n);
		}
	}
	//0의 호출 횟수를 저장하는 배열.
	public static int[] visited0;
	//1의 호출 횟수를 저장하는 배열.
	public static int[] visited1;
	
	public static void pibo(int n) {
		if (n == 0) {
			System.out.println(1+" "+0);
			return;
		}
		if (n == 1) {
			System.out.println(0+" "+1);
			return;
		}
		visited0[0] = 1;
		visited0[1] = 0;
		visited1[0] = 0;
		visited1[1] = 1;
		for (int i = 2; i <= n; i++) {
			visited0[i] = visited0[i-1] + visited0[i-2];
			visited1[i] = visited1[i-1] + visited1[i-2];
		}
		System.out.println(visited0[n]+" "+visited1[n]);
	}
}