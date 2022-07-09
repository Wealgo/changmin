import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(greedy());
	}
	
	public static int greedy() {
		int output = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int tmp = 0;
			tmp = arr[i] * (arr.length - i);
			if (tmp > output) {
				output = tmp;
			}
		}
		return output;
	}
}
