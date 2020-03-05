import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int jimin = sc.nextInt();
		int hansu = sc.nextInt();
		System.out.println(result(people, jimin, hansu));
	}
	//지민과 한수중 가장 큰 수를 가지고 있는 놈의 2의 지수가 n이라고 가정하고
	public static int result(int people, int jimin, int hansu){
		int max = jimin > hansu ? jimin : hansu;
		int n = (int) Math.pow(2.0, power(max)-1);
		//지민과 한수의 위치가 2의 n-1 제곱근과 2의 n제곱근 사이에 있으면
		if (power(jimin) == power(hansu)) {
			//2의 n-1제곱근부터 2의 n제곱근을 재귀로 다시 부른다.
			return result(people -n, jimin-n, hansu-n);
		//지민과 한수의 위치가 2의 n-1 제곱근과 2의 n제곱근 사이에 없으
		} else {
			//n을 리턴
			return power(jimin)>power(hansu) ? power(jimin) : power(hansu);
		}
	}
	public static int power(int person){
		for (int i = 0; i < 17; i++) {
			if (person <= Math.pow(2, i)) {
				return i;
			}
		}
		return 17;
	}
}
