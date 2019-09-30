import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	public static int k;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		k = (sc.nextInt());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < k; i++) {
			int tmp = sc.nextInt();
			if (tmp == 0) {
				stack.pop();
			} else {
				stack.push(tmp);
			}
		}
		int output = 0;
		for (int i = 0; i < stack.size(); i++) {
			output = output + stack.get(i);
		}
		System.out.println(output);
	}
}