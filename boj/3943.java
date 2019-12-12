import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int output = 0;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());
			//초기값을 설정해주자. 처음 입력받는 값이 제일 클테니까.
			output = n;
			//헤일스톤 재귀 가즈아~
			hailstone(n);
			System.out.println(output);
		}
	}
	public static void hailstone(int n) {
		//기저조건.
		if (n == 1) return;
		int next;
		//짝수면 절반으로, 홀수면 *3+1
		if (n%2 == 0) {
			next = n/2;
			//최대값이면 바꿔주자.
			if (output < next) {
				output = next;
			}
			hailstone(next);
		} else {
			next = ((n * 3) + 1);
			if (output < next) {
				output = next;
			}
			hailstone(next);
		}
	}
}
