import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * 문제의 점화식을 알면 쉽게 풀 수 있다.
 * (종류의 의상 갯수+1)*(종류의 의상 갯수+1)...(종류의 의상 갯수+1)-1
 */
public class Main {
	public static int[] alpabet = new int[26];
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			alpabet[(int)str.charAt(i)-65]++;
		}
		int max = 0;
		for (int i = 0; i < alpabet.length; i++) {
			if (max < alpabet[i]) {
				max = alpabet[i];
			}
		}
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < alpabet.length; i++) {
			if (alpabet[i] == max) {
				++cnt;
				idx = i;
			}
		}
		if (cnt == 1) {
			System.out.println((char)(idx+65));
		} else {
			System.out.println("?");
		}
	}
}
